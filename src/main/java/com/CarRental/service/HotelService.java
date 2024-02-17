package com.CarRental.service;

import com.CarRental.dto.HotelDto;

import java.util.List;

public interface HotelService {

    HotelDto addHotel(HotelDto hotelDto);

   List<HotelDto> getAllHotel();
}
