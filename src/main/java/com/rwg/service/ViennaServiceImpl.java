package com.rwg.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@Service
public class ViennaServiceImpl implements ViennaService
{

    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor viennaBookingPool;

    @Override
    public String hotelOrderBooking()
    {
        // 先返回rwg，然后线程池异步执行里面的逻辑。和之前的维也纳下单也是先返回新订单的状态，然后后台再去处理，然后推送到rabbitMq
        viennaBookingPool.execute(() -> excuteBook());
        return "直接返回新订单状态";
    }

    private void excuteBook()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        log.info("我刚执行完订单处理");

    }

    @Override
    public String returnHotelOrderBooking() throws ExecutionException, InterruptedException
    {

        // ExecutorService threadPool = Executors.newFixedThreadPool(1);
        List<Future<Integer>> futures = new ArrayList<>();
        // 这个countDownLatch的数量应保持和线程数量一致，才不会导致阻塞，因为利用的自定义线程池，
        // 没法准确知道线程实际开的数量，导出偶尔阻塞，建议使用newFixedThreadPool
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Future<Integer> future = viennaBookingPool.submit(() ->
        {
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            log.info("我刚执行完订单处理");
            return 1;
        });
        futures.add(future);
        countDownLatch.await();
        viennaBookingPool.shutdown();

        futures.stream().forEach(r ->
        {
            try
            {
                if (!future.isDone())
                {
                    log.info("资源还没准备好");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });

        return String.valueOf(future.get());
    }
}
