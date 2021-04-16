package com.rwg.controller;

import org.junit.Test;
import org.springframework.scheduling.annotation.Async;

public class AsyncTest
{
    @Test
    public void test3() throws Exception {
        System.out.println("main函数开始执行");
        longtime();
        System.out.println("main       函数执行结束");
    }

    @Async
    public void longtime() {
        System.out.println("我在执行  一项耗时任务");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完                                             成啦");
    }
}
