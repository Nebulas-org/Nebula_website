package com.gsac.nebulas.controller;

import com.gsac.nebulas.aop.Log;
import com.gsac.nebulas.model.User;
import com.gsac.nebulas.service.UserService;
import com.gsac.nebulas.utils.MessageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户
 * @author wlm
 * @date 2019-1-12 11:15:42
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "获取所有用户")
    @Log(action="findAll",modelName= "UserController",description="获取所有用户")
    @GetMapping("/findAll")
    public MessageResult findAll(){
        List<User> users = userService.queryAll();
        return MessageResult.ok(users);
    }

    @ApiOperation(value = "获取单个用户")
    @Log(action="findOneUser",modelName= "UserController",description="获取单个用户")
    @GetMapping("/findOneUser")
    public MessageResult findOneUser(@RequestParam(value = "id") Long id){
        MessageResult messageResult = MessageResult.ok();
       User user = userService.getById(id);
       if(null != user){
           messageResult.setResult(user);
       }else{
           messageResult = MessageResult.errorMsg("没有数据");
       }
        return messageResult;
    }

    @ApiOperation(value = "修改用户")
    @Log(action="updateUser",modelName= "UserController",description="修改用户")
    @PostMapping("/updateUser")
    public MessageResult updateUser(@ApiParam(value = "需要修改的数据id")@RequestBody User user){
        return userService.updateUser(user);
    }
}
