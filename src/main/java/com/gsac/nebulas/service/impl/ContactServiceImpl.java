package com.gsac.nebulas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsac.nebulas.dao.ContactMapper;
import com.gsac.nebulas.model.Contact;
import com.gsac.nebulas.model.ContactExample;
import com.gsac.nebulas.service.ContactService;
import com.gsac.nebulas.utils.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联系方式
 *
 * @author YI
 * @date 2018-8-29 16:29:50
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {
    @Autowired
    ContactMapper contactMapper;

    @Override
    public MessageResult saveSelective(Contact record) {
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Contact::getOwnership, record.getOwnership());
        Contact one = this.getOne(queryWrapper);
        if(null == one){
            this.save(one);
            messageResult.setCode(200);
            messageResult.setCount(1);
            messageResult.setMsg("保存成功");
            messageResult.setResult(one);
        }else {
            messageResult = MessageResult.errorMsg("公司名称已存在");
        }
        return messageResult;
    }

    @Override
    public List<Contact> selectByExample(ContactExample example) {
        return contactMapper.selectByExample(example);
    }

    @Override
    public MessageResult updateContact(Contact contact) {
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Contact::getId, contact.getId());
        Contact one = this.getOne(queryWrapper);
        if (null == one) {
            messageResult = MessageResult.errorMsg("没有获取到相关的公司信息");
        } else {
            if (null != contact.getAddress() && !one.getAddress().equals(contact.getAddress())) {
                one.setAddress(contact.getAddress());
            }
            if (null != contact.getEmail() && !one.getEmail().equals(contact.getEmail())) {
                one.setEmail(contact.getEmail());
            }
            if(null != contact.getOwnership() && !one.getOwnership().equals(contact.getOwnership())){
                one.setOwnership(contact.getOwnership());
            }
            if(null != contact.getPhone() && !one.getPhone().equals(contact.getPhone())){
                one.setPhone(contact.getPhone());
            }
            if(null != contact.getQq() && !one.getQq().equals(contact.getQq())){
                one.setQq(contact.getQq());
            }
            if(null != contact.getWx() && !one.getWx().equals(contact.getWx())){
                one.setWx(contact.getWx());
            }
            this.updateById(one);
            messageResult.setCode(200);
            messageResult.setCount(1);
            messageResult.setMsg("修改成功");
            messageResult.setResult(one);
        }
        return messageResult;
    }

    @Override
    public MessageResult findContact() {
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        List<Contact> list = this.list(queryWrapper);
        if(list.size()>0){
            messageResult.setResult(list);
            messageResult.setMsg("获取公司信息成功");
            messageResult.setCount(list.size());
            messageResult.setCode(200);
        }else{
            messageResult= MessageResult.errorMsg("未找到相关公司信息");
        }
        return messageResult;
    }
}
