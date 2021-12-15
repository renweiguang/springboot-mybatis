package com.rwg.controller;

import com.rwg.entity.Article;
import com.rwg.service.ArticleDaoService;
import com.rwg.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDaoService articleDaoService;

    @RequestMapping("/selectArticleCount")
    public Integer selectArticleCount() {
        return articleService.selectArticleCount();
    }

    @RequestMapping("selectArticle")
    public String selectArticle() {
        return articleDaoService.lambdaQuery().eq(Article::getTitle, "测试").one().getContent();
    }
}


