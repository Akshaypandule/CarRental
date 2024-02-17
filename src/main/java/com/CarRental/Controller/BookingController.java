package com.CarRental.Controller;

import com.CarRental.dto.BookingDto;
import com.CarRental.dto.BookingResponse;
import com.CarRental.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> createBookings(@RequestBody BookingDto bookingDto){
        BookingResponse booking = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
