package com.rwg.controller;

import com.rwg.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Controller
@RequestMapping("/aopController")
public class AopController
{
    @PostMapping(value = "/Curry")
    public void curry(@RequestBody User user)
    {
        System.out.println(user);
        System.out.println("库里上场打球了!!!");
    }

    @RequestMapping(value = "/Harden")
    public void Harden()
    {
        System.out.println("哈登上场打球了！！");
    }

    @RequestMapping(value = "/Antetokounmpo")
    public void Antetokounmpo()
    {
        System.out.println("字母哥上场打球了！！");
    }

    @RequestMapping(value = "/Jokic")
    public void Jokic()
    {
        System.out.println("约基奇上场打球了！！");
    }

    @RequestMapping(value = "/Durant")
    public void Durant(@RequestParam("point") int point)
    {
        System.out.println("杜兰特上场打球了！！");
    }
}
