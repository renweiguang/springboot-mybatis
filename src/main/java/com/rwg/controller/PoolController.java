package com.rwg.controller;

import com.rwg.service.BootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class PoolController
{
    @Autowired
    private BootService bootService;

    @RequestMapping("/pool")
    public String pool()
    {
        for (int i = 0; i < 100; i++)
        {
            bootService.testPool();
        }
        System.out.println("pool start");
        return "pool test";
    }

    @RequestMapping("/poolTask/{n}")
    public String poolTask(@PathVariable int n)
    {
        long startTime = System.currentTimeMillis();
        try
        {
            bootService.testPoolTaskExecutor(n);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        return "poolTask test " + (endTime - startTime) / 1000 + " 秒";
    }
}
