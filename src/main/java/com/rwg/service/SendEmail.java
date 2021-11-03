package com.rwg.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author rwg
 * @date 2021/9/7 9:44
 */

@Service
@RequiredArgsConstructor
@Order(value = 3)
public class SendEmail implements RepairCreatePostConsumer {


    @Override
    public void postHandler(String repairId) {
        System.out.println("为报修单" + repairId + "发送邮件");
    }

    @Override
    public boolean support(String xxx) {
        return true;
    }
}