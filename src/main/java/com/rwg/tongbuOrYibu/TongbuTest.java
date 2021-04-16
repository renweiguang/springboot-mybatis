package com.rwg.tongbuOrYibu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TongbuTest
{
    @Autowired
    MyTaskTongbu myTask;

    @GetMapping("/testTongbu")
    public void contextLoads() throws Exception
    {
        myTask.doTaskOne();
        myTask.doTaskTwo();
        myTask.doTaskThree();
    }
}
