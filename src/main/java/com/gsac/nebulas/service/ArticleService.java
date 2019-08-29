package com.gsac.nebulas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsac.nebulas.model.Article;
import com.gsac.nebulas.model.ArticleExample;
import com.gsac.nebulas.model.ArticleWithBLOBs;
import com.gsac.nebulas.utils.MessageResult;

import java.util.List;

/**
 * 文章操作
 * @author YI
 * @date 2018-8-30 11:47:38
 */
public interface ArticleService extends IService<Article> {

    /**
     * 保存文章
     * @param article
     * @return
     */
    MessageResult saveInfo(Article article);

    /**
     * 根据id查询文章详情
     * @param id
     * @return
     */
    ArticleWithBLOBs findArticle(Integer id);

    List<ArticleWithBLOBs> findHomeArticle(ArticleExample  example);

    /**
     * 获取所有文章，按创建时间倒叙
     * @return
     */
    List<Article> findAllArticle();

    /**
     * 分页查询+name 的模糊查询
     * @param pageIndex
     * @param pageSize
     * @param name
     * @return
     */
    MessageResult findByPage(Integer pageIndex,Integer pageSize,String name);

}
