package com.CarRental.Controller;

import com.CarRental.dto.HotelDto;
import com.CarRental.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("auth/customer/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto)
    {
        HotelDto hotelDto1 = hotelService.addHotel(hotelDto);
        return new ResponseEntity<>(hotelDto1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotel(){

        List<HotelDto> allHotel = hotelService.getAllHotel();
        return new ResponseEntity<>(allHotel,HttpStatus.OK);

    }
}
