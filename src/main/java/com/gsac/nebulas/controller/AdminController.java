package com.gsac.nebulas.controller;

import com.gsac.nebulas.service.ContactService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网站管理
 * @author YI
 * @date 2018-8-29 11:34:58
 */

@RestController
@Api(description = "网站管理")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ContactService contactService;

    @RequestMapping("/index")
    public String index(){
        return "work/admin";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "work/contact";
    }
}
