package com.gsac.nebulas.controller;

import com.gsac.nebulas.aop.Log;
import com.gsac.nebulas.config.Constant;
import com.gsac.nebulas.model.Article;
import com.gsac.nebulas.model.ArticleWithBLOBs;
import com.gsac.nebulas.service.ArticleService;
import com.gsac.nebulas.utils.MessageResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章
 * @author YI
 * @date 2018-8-30 11:55:09
 */
@RestController
@RequestMapping("/article")
@Api(description = "文章")
public class ArticleController {
    @Autowired
    ArticleService articleService;


    @ApiOperation(value = "保存文章")
    @Log(action="saveArticle",modelName= "ArticleController",description="保存文章")
    @PostMapping("/saveArticle")
    public MessageResult saveArticle(@RequestBody ArticleWithBLOBs article){
        MessageResult result ;
        if (article == null){
            return MessageResult.errorMsg("内容不能为空");
        }

        if (article.getContent() == null){
            return MessageResult.errorMsg("文章不能为空");
        }

        if (article.getTitle() == null){
            return MessageResult.errorMsg("文章标题不能为空");
        }

        try {
            result = articleService.saveInfo(article);
        }catch (Exception e){
            result = MessageResult.errorMsg(e.getMessage());
        }

        return result;
    }


    @ApiOperation(value = "获取所有文章")
    @Log(action="getArticles",modelName= "ArticleController",description="获取文章")
    @GetMapping("/getArticles")
    public MessageResult getArticles(){
        MessageResult messageResult =  MessageResult.ok();
        List<Article> allArticle = articleService.findAllArticle();
        if(allArticle.size()>0){
            messageResult.setResult(allArticle);
            messageResult.setCount(allArticle.size());
            messageResult.setCode(Constant.SUCCESS);
        }else{
           messageResult= MessageResult.errorTokenMsg("未得到数据信息");
        }
        return messageResult;
    }



    @ApiOperation(value = "分页获取文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex",value = "第几页",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页几条数据",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "模糊查询标题",dataType = "String",paramType = "query")
    })
    @Log(action="getArticlesByPages",modelName= "ArticleController",description="获取文章")
    @GetMapping("/getArticlesByPages")
    public MessageResult getArticlesByPages(@RequestParam(name ="pageIndex" ,defaultValue = "1",required = false) Integer pageIndex,
                                            @RequestParam(name ="pageSize" ,defaultValue = "10",required = false) Integer pageSize,
                                            @RequestParam(name = "name",required = false) String name){
        MessageResult messageResult  = articleService.findByPage(pageIndex,pageSize,name);
        return messageResult;
    }


    @ApiOperation(value = "删除文章")
    @Log(action = "deleteArticle", modelName = "ArticleController", description = "删除文章")
    @PostMapping("/deleteArticle ")
    public MessageResult deleteArticle(@ApiParam(value = "id必传,按list传参")@RequestParam List<Long> ids) {
        MessageResult messageResult = MessageResult.ok();
        boolean b = articleService.removeByIds(ids);
        if(b){
            messageResult.setMsg("删除成功!");
            messageResult.setCount(ids.size());
            messageResult.setCode(Constant.SUCCESS);
        }else{
            messageResult = MessageResult.errorMsg("删除失败!");
        }
        return messageResult;
    }


    @ApiOperation(value = "根据id文章")
    @Log(action = "getOneArticle", modelName = "ArticleController", description = "根据id文章")
    @GetMapping("/getOneArticle ")
    public MessageResult getOneArticle(@RequestParam("id") Long id){
        MessageResult messageResult = MessageResult.ok();
        Article article = articleService.getById(id);
        if(null != article){
            messageResult.setResult(article);
        }else {
            messageResult = MessageResult.errorMsg("没有数据");
        }
        return messageResult;
    }
    @ApiOperation(value = "根据id修改文章")
    @Log(action = "updateArticleById", modelName = "ArticleController", description = "根据id文章")
    @PostMapping("/updateArticleById ")
    public MessageResult updateArticleById(@ApiParam(value = "id必传")@RequestParam Article article){
        MessageResult messageResult = MessageResult.ok();
        if(article.getId()==null){
            messageResult = MessageResult.errorMsg("id不能为空");
        }else{
            boolean b = articleService.updateById(article);
            if(b){
                messageResult.setResult(article);
            }else {
                messageResult = MessageResult.errorMsg("修改失败！");
            }
        }
        return messageResult;
    }

}
