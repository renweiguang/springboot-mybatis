package com.rwg.controller;

import org.junit.Test;
import org.springframework.scheduling.annotation.Async;

public class AsyncTest
{
    @Test
    public void test3() throws Exception
    {
        System.out.println("main函数开始执行");
        longtime();
        System.out.println("新增功能了。。。。。。。。。。。。。。。。");
    }

    @Async
    public void longtime()
    {
        System.out.println("我在         执行一项耗时任务");
        System.out.println("我     在执行一项耗时任务");
        System.out.println("我在执   行一项    耗时任务");
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("完成啦");
    }
}
