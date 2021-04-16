package com.rwg.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class ScheduledTask {

    @Scheduled(cron = "0/10 * * * * ?") //每10秒执行一次
    public void scheduledTaskByCorn() {
        log.info("定时任务开始 ByCorn：" + new Date());
        scheduledTask();
        log.info("定时任务结束 ByCorn：" + new Date());
    }

    @Scheduled(fixedRate = 10000) //每10秒执行一次
    public void scheduledTaskByFixedRate() {
        log.info("定时任务开始 ByFixedRate：" + new Date());
        scheduledTask();
        log.info("定时任务结束 ByFixedRate：" + new Date());
    }

    @Scheduled(fixedDelay = 10000) //每10秒执行一次
    public void scheduledTaskByFixedDelay() {
        log.info("定时任务开始 ByFixedDelay：" + new Date());
        scheduledTask();
        log.info("定时任务结束 ByFixedDelay：" + new Date());
    }

    private void scheduledTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}