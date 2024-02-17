package com.CarRental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarDto {

    private String id;

    @NotNull(message = "carCompany is required")
    private String carCompany;
    @NotNull(message = "carColor is required")
    private String carColor;
    @NotNull(message = "carType is required")
    private String carType;
    @NotNull(message = "carModel is required")
    private String carModel;
    @NotNull(message = "carImage is required")
    private String carImg;
    private String car360;
    @NotNull(message = "carOwner name is required")
    private String carOwner;
    @NotNull(message = "car Number is required")
    private String numPlate;
    @NotNull(message = "regDate is required")
    private LocalDate regDate;
    @NotNull(message = "Insurance type is required")
    private String insurance;
    @NotNull(message = "insuranceValidity is required")
    private LocalDate insuranceValidity;
    @NotNull(message = "passengerCapacity is required")
    private Integer passangerCapacity;
    @NotNull(message = "FuelType is required")
    private String fuelType;
    @NotNull(message = "feature is required")
    private String feature;
    @NotNull(message = "totalRunning is required")
    private Integer totalRunning;
    @NotNull(message = "Charges is required")
    private Double charge;
}
