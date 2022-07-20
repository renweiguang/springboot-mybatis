package com.rwg.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.rwg.entity.Article;
import com.rwg.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 1.新增 , insert方法
     * @param article
     * @return
     */
    public boolean save(Article article){
        return articleMapper.insert(article) > 0;
    }

    /**
     * 2.通过QueryWrapper查询数量
     */
    public Integer selectArticleCount(){
        return articleMapper.selectCount(Wrappers.<Article>query().lambda()
               .eq(Article::getTitle,"测试"));
    }

    /**
     * 3.通过selectMaps查询list<Map<String, Object>>
     */
    public List<Map<String, Object>> selectArticleMaps(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", "测试");
        List<Map<String, Object>> list = articleMapper.selectMaps(queryWrapper);
        return list;
    }

    /**
     * 4.通过QueryWrapper查询list<Object>
     */
    public List<Object> selectObjs()
    {
        List<Object> list = articleMapper.selectObjs(new QueryWrapper<Article>().eq("title", "测试"));
        return list;
    }

    /**
     * 6，删除，根据articleId来删除
     */
    public boolean delete(Long articleId)
    {
        return articleMapper.deleteById(articleId) > 0;
    }

    /**
     * 7，删除，根据QueryWrapper删除
     */
    public boolean deleteByQueryWrapper()
    {
        return articleMapper.delete(new QueryWrapper<Article>().eq("title", "测试")) > 0;
    }

    /**
     * 8, 批量删除，把多个id存放到list中，再批量删除，其实很少会用到
     */
    public boolean deleteBatchIds(List<Long> articleIdList)
    {
        return articleMapper.deleteBatchIds(articleIdList) > 0;
    }

    /**
     * 9，修改  封装方法中做了非空校验，如果该字段为null,则不进行更新
     */
    public boolean updateById(Article article) {
        return articleMapper.updateById(article) > 0;
    }
}


