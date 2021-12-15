package com.rwg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rwg.entity.Article;
import com.rwg.entity.EntityQo;

public interface ArticleDaoService extends IService<Article> {

    IPage<Article> getPageByCondition(EntityQo entityQo);
}
