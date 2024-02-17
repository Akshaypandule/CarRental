package com.CarRental.service;

import com.CarRental.dto.DriverDto;

import java.util.List;

public interface DriverService {

    DriverDto createDriver(DriverDto driverDto);

    DriverDto getSingleDriver(String id);

    List<DriverDto> getAllDriver();
}
