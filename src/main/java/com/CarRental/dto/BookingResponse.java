package com.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse
{
    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carOwner;
    private String carImg;
    private String numPlate;
    private LocalDate insuranceValidity;
    private String fuelType;
    private String feature;
    private String pickUpLocation;
    private String dropLocation;
    private String pickUpTime;
    private String pickUpDate;
    private String dropDate;
    private int passangerCapacity;
    private int members;
    private int days;
    private int numBags;
    private Double totalPrice;
    private String carId;
}
