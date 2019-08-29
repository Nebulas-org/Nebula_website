package com.gsac.nebulas.controller;

import com.gsac.nebulas.aop.Log;
import com.gsac.nebulas.model.Contact;
import com.gsac.nebulas.service.ContactService;
import com.gsac.nebulas.utils.MessageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 联系详情
 * @author wlm
 * @date 2018-8-29 21:31:04
 */
@RestController
@RequestMapping("/contact")
@Api(description = "公司联系详情")
public class ContactController {
    @Autowired
    ContactService contactService;


    @ApiOperation(value = "获取联系详情")
    @Log(action="findLastOneContact",modelName= "ContactController",description="获取联系详情")
    @GetMapping("/findLastOneContact")
    public MessageResult findLastOneContact(){
        MessageResult result = contactService.findContact();
        return result;
    }

    /**
     * 保存联系方式
     * @param contact
     * @return
     */
    @ApiOperation(value = "保存联系方式")
    @Log(action="saveContact",modelName= "ContactController",description="保存联系方式")
    @PostMapping("/saveContact")
    public MessageResult saveContact(@RequestBody Contact contact){
        MessageResult result = contactService.saveSelective(contact);
        return result;
    }
    /**
     * 修改联系方式
     * @param contact
     * @return
     */
    @ApiOperation(value = "修改联系方式")
    @Log(action="updateContact",modelName= "ContactController",description="修改联系方式")
    @PostMapping("/updateContact")
    public MessageResult updateContact(@RequestBody Contact contact){
        MessageResult result = contactService.updateContact(contact);
        return result;
    }
}
