package com.CarRental.service;

import com.CarRental.dto.BookingDto;
import com.CarRental.dto.BookingResponse;

public interface BookingService {


    BookingResponse createBooking(BookingDto bookingDto);

    BookingResponse getBooking(String id);


}
