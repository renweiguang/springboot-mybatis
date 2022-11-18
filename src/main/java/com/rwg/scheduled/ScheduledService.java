package com.rwg.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduledService {
    @Scheduled(cron = "0 */1 * * * ?")
    public void sayHello() {
        System.out.println("定时任务1:" + new Date() + "hello");
    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void sayNo() {
        System.out.println("定时任务2:" + new Date() + "No++");
    }
}
