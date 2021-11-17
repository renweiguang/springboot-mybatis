package com.rwg.controller;

/**
 * @author rwg
 * @date 2021/11/17 10:02
 */

import java.util.concurrent.TimeUnit;

import com.rwg.config.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SpringBootController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/hello/{id}")
    public String hello(@PathVariable(value = "id") String id) {
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id);
        String str = "rwggggg";
        if (hasKey) {
            //获取缓存
            Object object = redisUtils.get(id);
            log.info("从缓存获取的数据" + object);
            str = object.toString();
        } else {
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id, str, 10L, TimeUnit.MINUTES);
            log.info("数据插入缓存" + str);
        }
        return str;
    }
}
