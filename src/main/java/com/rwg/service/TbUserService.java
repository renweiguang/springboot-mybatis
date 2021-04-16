package com.rwg.service;

import com.github.pagehelper.PageInfo;
import com.rwg.entity.TbUser;

public interface TbUserService
{
    PageInfo<TbUser> getUserList(int page, int limit);
}
