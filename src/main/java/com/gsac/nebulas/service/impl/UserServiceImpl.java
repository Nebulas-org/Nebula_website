package com.gsac.nebulas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsac.nebulas.config.Constant;
import com.gsac.nebulas.dao.UserMapper;
import com.gsac.nebulas.model.User;
import com.gsac.nebulas.model.UserExample;
import com.gsac.nebulas.service.UserService;
import com.gsac.nebulas.utils.MessageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户操作实现类
 * @author YI
 * @date 2018-8-29 11:11:39
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public boolean queryUsernameIsExist(Long phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getMobile,phone);
        User one = this.getOne(queryWrapper);
        return one == null ? false : true;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void saveUser(User user) {

        userMapper.insert(user);
    }

    @Override
    public User queryUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getMobile,username);
        User user = this.getOne(queryWrapper);
        return user;
    }

    @Override
    public List<User> queryAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

    @Override
    public List<User> queryUsernameAndPassWord(String username, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        return userMapper.selectByExample(example);
    }

    @Override
    public MessageResult updateUser(User user) {
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getId,user.getId());
        User user1 = this.getOne(queryWrapper);
        if(null == user1){
            messageResult = MessageResult.errorMsg("没有找到用户数据");
        }else{
            if(!user1.getName().equals(user.getName())){
                user1.setName(user.getName());
            }
            if(!user1.getEmail().equals(user.getEmail())){
                user1.setEmail(user.getEmail());
            }
            if(!user1.getStatus().equals(user.getStatus())){
                user1.setStatus(user.getStatus());
            }
            if(!user1.getType().equals(user.getType())){
                user1.setType(user.getType());
            }
            if(!user1.getAvatar().equals(user.getAvatar())){
                user1.setAvatar(user.getAvatar());
            }
            this.updateById(user1);
            messageResult.setCode(Constant.SUCCESS);
            messageResult.setCount(Constant.GenericNumber.NUMBER_ONE);
            messageResult.setMsg("成功！");
            messageResult.setResult(user1);
        }
        return messageResult;
    }
}
