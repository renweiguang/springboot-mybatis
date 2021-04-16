package com.rwg.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rwg.entity.TbUser;
import com.rwg.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService
{
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public PageInfo<TbUser> getUserList(int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<TbUser> userList = tbUserMapper.getUserList();
        PageInfo<TbUser> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}
