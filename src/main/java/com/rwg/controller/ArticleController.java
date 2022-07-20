package com.rwg.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rwg.entity.Article;
import com.rwg.entity.EntityQo;
import com.rwg.mapper.ArticleMapper;
import com.rwg.service.ArticleDaoService;
import com.rwg.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDaoService articleDaoService;

    @Autowired
    private ArticleMapper articleMapper;

    @RequestMapping("/selectArticleCount")
    public Integer selectArticleCount() {
        return articleService.selectArticleCount();
    }

    /**
     * @Description 只查询指定字段
     * @author renwg
     * @date 2022/4/28
     */
    @RequestMapping("selectArticle")
    public List<Article> selectArticle() {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("article_id", "title").like("title", "测试").eq("article_id",2);
        List<Article> articleList = articleMapper.selectList(queryWrapper);
        return articleList;
    }

    @RequestMapping("selectIpageArticle")
    public IPage<Article> selectIpageArticle() {
        return articleDaoService.getPageByCondition(EntityQo.builder().title("测试").build());
    }
}


