package com.rwg.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class BootService {
    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @Async
    public void testPool() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    public int testPoolTaskExecutor(int n) throws InterruptedException, ExecutionException {

        ArrayList<Future<Integer>> futures = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(n);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            final int index = i;
            final Future<Integer> future = poolTaskExecutor.submit(() ->
            {
                Thread.sleep(2000);
                System.out.println(
                        simpleDateFormat.format(new Date()) + " " + Thread.currentThread().getName() + " 执行 " + index);
                countDownLatch.countDown();
                return index;
            });
            futures.add(future);
        }

        // 加上他说明主线程等待线程池执行结束后，在执行下面，就不会出现资源没准备好现象，如果删掉，会出现。
        countDownLatch.await();

        System.out.println("-------------------------------------------------------------------------------------------");


        /**
         * 这个例子完美展现future 如果get不到结果，会阻塞。
         */
        for (Future<Integer> future : futures) {
            if (!future.isDone()) {
                System.out.println("资源还没有准备好");
            }
            System.out.println(future.get());
        }
        return sum;
    }
}