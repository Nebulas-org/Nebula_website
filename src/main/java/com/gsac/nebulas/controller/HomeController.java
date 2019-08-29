package com.gsac.nebulas.controller;

import com.gsac.nebulas.model.*;
import com.gsac.nebulas.service.ArticleService;
import com.gsac.nebulas.service.BannerService;
import com.gsac.nebulas.service.ContactService;
import com.gsac.nebulas.service.PresentationService;
import com.gsac.nebulas.utils.MessageResult;
import com.gsac.nebulas.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 官网
 * @author YI
 * @date 2018-8-29 14:49:05
 */
@RequestMapping("/open")
@RestController
public class HomeController {
    @Autowired
    BannerService bannerService;
    @Autowired
    ContactService contactService;
    @Autowired
    PresentationService presentationService;
    @Autowired
    ArticleService articleService;

    /**
     * 主页数据
     * @return
     */
    @RequestMapping("/home")
    public MessageResult home(){
        MessageResult result = MessageResult.ok();
        Map<String, Object> map = new HashMap<>(16);

        // banner
        BannerExample example = new BannerExample();
        example.setLimit(2);
        example.setOrderByClause("create_time DESC");

        BannerExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.GREEN.getValue());

        MessageResult picture = bannerService.findPicture(1, 10, null, 0);

        map.put("banners", picture.getResult());

        // 联系
        ContactExample contactExample = new ContactExample();
        contactExample.setLimit(1);
        contactExample.setOrderByClause("crateDate DESC");

        MessageResult contact = contactService.findContact();

        map.put("contacts", contact.getResult());

        // 简介
//        Presentation presentation = presentationService.find();
//
//        map.put("presentation", presentation);

        // 文章
//        ArticleExample articleExample = new ArticleExample();
//        articleExample.setLimit(8);
//        articleExample.setOrderByClause("create_time DESC");

//        List<ArticleWithBLOBs> homeArticle = articleService.findHomeArticle(articleExample);
//        map.put("article", homeArticle);

        result.setResult(map);

        return result;
    }

    /**
     * 根据id查询文章详情
     * @param id
     * @return
     */
    @RequestMapping("/findArticle")
    public MessageResult findArticle(Integer id){
        MessageResult result = MessageResult.ok();
        if (id == null){
            return MessageResult.errorMsg("id不能为空");
        }

        try {
            ArticleWithBLOBs article = articleService.findArticle(id);
            result.setResult(article);
        }catch (Exception e){
            result = MessageResult.errorMsg(e.getMessage());
        }

        return result;
    }
}
