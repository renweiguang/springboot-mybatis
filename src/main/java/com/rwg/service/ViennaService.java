package com.rwg.service;

import java.util.concurrent.ExecutionException;

public interface ViennaService
{
    String hotelOrderBooking();

    String returnHotelOrderBooking() throws ExecutionException, InterruptedException;
}
