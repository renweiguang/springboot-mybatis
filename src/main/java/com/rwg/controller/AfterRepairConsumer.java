package com.rwg.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.rwg.service.RepairCreatePostConsumer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rwg
 * @date 2021/9/7 9:43
 */

/**
 * 模板模式  作用
 */
@RestController
@RequestMapping(value = "/pc/api/v1/monitor")
@AllArgsConstructor
public class AfterRepairConsumer implements RepairCreatePostConsumer {

    // 按理说final修饰的变量必须要初始化
    // 不用@Resource的原因是:::使用了@AllArgsConstructor注解，他相当于写了一个构造方法，将postConsumers实例化了。
    private final List<RepairCreatePostConsumer> postConsumers;

    @GetMapping(value = "/create")
    public String create() {
        final String repairId = "3";
        //按理说也会将自己注入（因为自己也实现了这个接口了），但是@resource注解为了防止循环注入，将本身剔除了。。。
        if (CollectionUtil.isNotEmpty(postConsumers)) {
            System.out.println(postConsumers);
            postConsumers.forEach(e -> {
                if (e.support(repairId)) {
                    e.postHandler(repairId);
                }
            });
        }
        return "success";
    }

    @Override
    public void postHandler(String repairId) {

    }

    @Override
    public boolean support(String xxx) {
        return false;
    }
}
