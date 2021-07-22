package com.rwg.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author rwg
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/guava")
public class GuavaController {

    public static final ExecutorService service = Executors.newCachedThreadPool();


    @RequestMapping("/test")
    public void test() throws ExecutionException, InterruptedException
    {
        long start = System.currentTimeMillis();

        // 任务1
        Future<Boolean> booleanTask = service.submit(new Callable<Boolean>()
        {
            @Override
            public Boolean call() throws Exception
            {
                Thread.sleep(10000);
                return true;
            }
        });

        // 任务2
        Future<String> stringTask = service.submit(new Callable<String>()
        {

            @Override
            public String call() throws Exception
            {
                Thread.sleep(3000);
                return "Hello World";
            }
        });

        // 任务3
        Future<Integer> integerTask = service.submit(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                Thread.sleep(2000);
                return new Random().nextInt(100);
            }
        });

        while (true)
        {
            if (booleanTask.isDone() && !booleanTask.isCancelled())
            {
                Boolean result = booleanTask.get();
                System.err.println("任务1-10s： " + result);
                break;
            }
        }

        while (true)
        {
            if (stringTask.isDone() && !stringTask.isCancelled())
            {
                String result = stringTask.get();
                System.err.println("任务2-3s： " + result);
                break;
            }
        }

        while (true)
        {
            if (integerTask.isDone() && !integerTask.isCancelled())
            {
                Integer result = integerTask.get();
                System.err.println("任务3-2s：" + result);
                break;
            }
        }

        // 执行时间
        System.err.println("time: " + (System.currentTimeMillis() - start));
    }

}
