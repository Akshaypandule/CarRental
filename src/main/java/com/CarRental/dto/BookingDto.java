package com.CarRental.dto;

import com.CarRental.entity.Car;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private String carId;
    @NotNull(message = "PickUpLocation Must be Required")
    private String pickUpLocation;
    @NotNull(message = "DropLocation Must be Required")
    private String dropLocation;
    @NotNull(message = "PickUpTime Must be Required")
    private String pickUpTime;
    @NotNull(message = "PickUpDate Must be Required")
    private String pickUpDate;
    @NotNull(message = "dropDate Must be Required")
    private String dropDate;
    @NotNull(message = "PassengerCapacity Must be Required")
    private Integer passangerCapacity;
    @NotNull(message = "member Must be Required")
    private Integer members;
    @NotNull(message = "days Must be Required")
    private Integer days;
    @NotNull(message = "numBags Must be Required")
    private Integer numBags;
   // private CarDto car;
}
