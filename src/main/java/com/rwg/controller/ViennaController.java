package com.rwg.controller;

import com.rwg.service.ViennaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

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
    public String returnTestBook(@RequestParam(name = "order") String order)
            throws ExecutionException, InterruptedException
    {
        String returnString = viennaService.returnHotelOrderBooking();
        log.info(returnString);

        return returnString;
    }
}
