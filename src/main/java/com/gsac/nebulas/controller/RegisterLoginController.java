package com.gsac.nebulas.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.gsac.nebulas.aop.Log;
import com.gsac.nebulas.config.Constant;
import com.gsac.nebulas.config.RedisOperator;
import com.gsac.nebulas.model.User;
import com.gsac.nebulas.model.UserVo;
import com.gsac.nebulas.service.UserService;
import com.gsac.nebulas.utils.CookieUtil;
import com.gsac.nebulas.utils.MessageResult;
import io.swagger.annotations.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录注册
 * @author wlm
 * @date
 */
@Slf4j
@Api(description = "登陆注册")
@RestController
@RequestMapping("/user")
public class RegisterLoginController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterLoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    public RedisOperator redis;

    @ApiOperation(value = "用户注册，手机号码注册，区分手机号码唯一性")
    @Log(action="register",modelName= "RegisterLoginController",description="用户注册")
    @PostMapping(value = "/register")
    public MessageResult register(@RequestBody User user){
        if (user == null || StringUtils.isBlank(user.getMobile()+"") || StringUtils.isBlank(user.getPassword())){
            return MessageResult.errorMsg("用户名或者密码不能为空");
        }
        boolean isExist = userService.queryUsernameIsExist(user.getMobile());
        if (isExist){
            return MessageResult.errorMsg("用户名已存在");
        }else {
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));

            userService.saveUser(user);
        }
//        List<User> userList = userService.queryUsernameAndPassWord(user.getName(), user.getPassword());
        UserVo userVo = setUserRedisSessionToken(user);
        userVo.setPassword("");

        return MessageResult.ok(userVo);
    }

    @ApiOperation(value = "用户登录")
    @Log(action="login",modelName= "RegisterLoginController",description="登陆认证(手机号码+密码)")
    @PostMapping(value = "/login")
    public MessageResult login(@ApiParam(value = "手机号码") @RequestParam(value = "mobile")String mobile,@RequestParam(value = "password") String password) {
        MessageResult respMessage = new MessageResult();
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(password)){
            respMessage.setCode(-1);
            respMessage.setMsg("用户名或者密码不能为空");
            logger.info("error : 用户名或者密码不能为空");
            return respMessage;
        }

        User user = userService.queryUsername(mobile);
        if (user == null){
            respMessage.setCode(-1);
            respMessage.setMsg("用户不存在!");
            logger.info("error : 用户不存在");
            return respMessage;
        }

        if (!user.getPassword().equals(DigestUtil.md5Hex(password))){
            respMessage.setCode(-1);
            respMessage.setMsg("用户或密码不正确!");
            logger.info("error : 用户或密码不正确");
            return respMessage;
        }

        UserVo userVo = setUserRedisSessionToken(user);
        userVo.setPassword("");
        respMessage.setResult(userVo);

        CookieUtil.addCookie("userToken", userVo.getUserToken());
        CookieUtil.addCookie("userId", userVo.getId());
        logger.info("userToken : " + userVo.getUserToken());

        return respMessage;
    }

    /**
     * 用户注销
     * @param userId 用户id
     * @return
     */
    @ApiOperation(value = "用户注销")
    @Log(action="logout",modelName= "RegisterLoginController",description="用户注销")
    @PostMapping(value = "/logout")
    public MessageResult logout(String userId){
        redis.del(Constant.USER_REDIS_SESSION + ":" + userId);
        return MessageResult.ok();
    }

    /**
     * 把Token放入redis
     * @param user
     * @return
     */
    private UserVo setUserRedisSessionToken(User user){
        String token = SecureUtil.simpleUUID();
        redis.set(Constant.USER_REDIS_SESSION + ":" + user.getId(), token, Constant.REDIS_TIMEOUT);
        UserVo userVo = new UserVo();
        BeanUtil.copyProperties(user, userVo);
        userVo.setUserToken(token);
        return userVo;
    }
}
