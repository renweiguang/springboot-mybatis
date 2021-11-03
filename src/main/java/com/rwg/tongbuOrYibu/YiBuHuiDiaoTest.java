package com.rwg.tongbuOrYibu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
class YiBuHuiDiaoTest
{
    @Autowired
    MyTaskYiBuHuiDiao myTask;

    @GetMapping("/testYiBuHuiDiao")
    public void contextLoads() throws Exception
    {
        long start = System.currentTimeMillis();
        Future<String> task1 = myTask.doTaskOne();
        Future<String> task2 = myTask.doTaskTwo();
        Future<String> task3 = myTask.doTaskThree();
        task1.get();
        task2.get();
        task3.get();
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}
