package com.rwg.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rwg.entity.Article;
import com.rwg.entity.EntityQo;
import com.rwg.mapper.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
@Slf4j
public class ArticleDaoServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleDaoService {


    @Resource
    private ArticleMapper articleMapper;

    @Override
    public IPage<Article> getPageByCondition(EntityQo entityQo) {
        LambdaQueryWrapper<Article> wrapper = this.buildQueryParam(entityQo);
        Page<Article> page = new Page<>(entityQo.getPageNo(), entityQo.getPageSize());
        return articleMapper.selectPage(page, wrapper);
    }


    private LambdaQueryWrapper<Article> buildQueryParam(EntityQo qo) {
        return Wrappers.<Article>lambdaQuery()
                .eq(Objects.nonNull(qo.getTitle()), Article::getTitle, qo.getTitle());
    }
}
