package com.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinalPaymentDto
{
    private String id;
    private String cardNo;
    private String cardHolder;
    private String expDate;
    private String fname;
    private String lname;
    private String email;
    private String driverImg;
    private String driverName;
    private String driverMobNo;
    private String charges;
    private String stay;
    private String hotel;
    private String room;
    private String finalCost;
    private String manageParking;
    private String charge;
    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carImg;
    private String fuelType;
    private String pickUpLocation;
    private String pickUpDate;
    private String dropLocation;
    private String dropDate;
    private String pickUpTime;
    private String members;
    private String days;
    private String passangerCapacity;
    private String driverID;
}
