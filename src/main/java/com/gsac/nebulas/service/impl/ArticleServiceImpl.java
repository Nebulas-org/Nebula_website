package com.gsac.nebulas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsac.nebulas.dao.ArticleMapper;
import com.gsac.nebulas.model.Article;
import com.gsac.nebulas.model.ArticleExample;
import com.gsac.nebulas.model.ArticleWithBLOBs;
import com.gsac.nebulas.service.ArticleService;
import com.gsac.nebulas.utils.MessageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章操作
 *
 * @author YI
 * @date 2018-8-30 11:47:38
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Resource
    ArticleMapper articleMapper;

    @Override
    public MessageResult saveInfo(Article article) {
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        List<Article> list = this.list(queryWrapper);
        if (list.size() > 0) {
            for (Article art : list) {
                if (art.getTitle().equals(article.getTitle())) {
                    messageResult = MessageResult.errorMsg("文章标题重复");
                    return messageResult;
                }
            }
        }
        article.setCreateTime(LocalDateTime.now());
        this.baseMapper.insert(article);
        messageResult.setResult(article);
        messageResult.setCode(200);
        messageResult.setMsg("保存成功！");
        return messageResult;
    }

    @Override
    public ArticleWithBLOBs findArticle(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ArticleWithBLOBs> findHomeArticle(ArticleExample example) {
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Article> findAllArticle() {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        return this.list(queryWrapper);
    }

    @Override
    public MessageResult findByPage(Integer pageIndex, Integer pageSize, String name) {
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        if (null != name) {
            queryWrapper.like("title", name);
        }
        IPage<Article> iPage = this.page(new Page<>(pageIndex, pageSize), queryWrapper);
        if (iPage.getRecords().size() > 0) {
            messageResult.setCount((int) iPage.getTotal());
            messageResult.setMsg("获取数据成功");
            messageResult.setCode(200);
            messageResult.setResult(iPage);
        } else {
            messageResult = MessageResult.errorMsg("没有数据");
        }
        return messageResult;
    }
}
