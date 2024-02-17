package com.CarRental.service;

import com.CarRental.dto.CarDto;

import java.util.List;

public interface CarService {

    CarDto addCar(CarDto carDto);

    CarDto getSingleCar(String id);

    List<CarDto> getAllCar();

    void deleteCar(String id);
}
