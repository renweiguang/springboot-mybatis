package com.rwg.controller;

import com.rwg.service.ViennaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * 模仿维也纳下单模块，异步下单直接返回新订单的状态。
 *
 *
 * 使用线程池下单。。。
 */



@Slf4j
@RestController
@RequestMapping("order")
public class ViennaController
{
    @Autowired
    private ViennaService viennaService;

    @PostMapping("/testBooking")
    public String testBook(@RequestParam(name = "order") String order)
    {
        String returnString = viennaService.hotelOrderBooking();
        log.info(returnString);

        return returnString;
    }


    @PostMapping("/returnTestBooking")
    public String returnTestBook(@RequestBody String order)
            throws ExecutionException, InterruptedException
    {
        String returnString = viennaService.returnHotelOrderBooking();
        log.info(returnString);

        return returnString;
    }
}
