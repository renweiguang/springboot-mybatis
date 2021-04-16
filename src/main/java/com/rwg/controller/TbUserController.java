package com.rwg.controller;

import com.github.pagehelper.PageInfo;
import com.rwg.entity.TbUser;
import com.rwg.service.TbUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后端实现分页
 */

@RestController
public class TbUserController
{
    @Autowired
    private TbUserServiceImpl tbUserService;

    @RequestMapping("/list")
    public PageInfo<TbUser> list(@RequestParam(value = "page", required = false, defaultValue = "1") int page)
    {
        return tbUserService.getUserList(page, 5);
    }
}
