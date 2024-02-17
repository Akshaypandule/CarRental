package com.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private String id;
    private String driverImg;
    private String driverName;
    private String drivingExperiance;
    private long driverMobNo;
    private String availability;
    private String food;
    private String smoke;
    private String drink;
    private Double charges;
}