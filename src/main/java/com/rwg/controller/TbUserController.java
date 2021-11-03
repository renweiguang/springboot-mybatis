package com.rwg.controller;

import com.github.pagehelper.PageInfo;
import com.rwg.annotation.AppUserInfo;
import com.rwg.entity.TbUser;
import com.rwg.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后端实现分页
 */

@RestController
@RequestMapping(value = "/tbUser")
public class TbUserController
{
    @Autowired
    private TbUserService tbUserService;

    @AppUserInfo
    @RequestMapping("/list")
    public PageInfo<TbUser> list(@RequestParam(value = "page", required = false, defaultValue = "1") int page)
    {
        return tbUserService.getUserList(page, 2);
    }
}
