package com.gsac.nebulas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsac.nebulas.model.Contact;
import com.gsac.nebulas.model.ContactExample;
import com.gsac.nebulas.utils.MessageResult;

import java.util.List;

/**
 * 联系方式
 * @author wlm
 * @date 2018-8-29 16:29:50
 */
public interface ContactService extends IService<Contact> {
    /**
     * 保存联系方式
     * @param record
     * @return
     */
    MessageResult saveSelective(Contact record);

    /**
     * 按条件查询
     * @param example 条件
     * @return
     */
    List<Contact> selectByExample(ContactExample example);

    /**
     * 根据id修改公司信息
     * @param contact
     * @return
     */
    MessageResult updateContact(Contact contact);
    /**
     * 获取公司信息
     * @param
     * @return
     */
    MessageResult findContact();
}
