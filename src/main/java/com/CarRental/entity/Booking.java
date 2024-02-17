package com.CarRental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Timer;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String pickUpLocation;
    private String dropLocation;
    private String pickUpTime;
    private String pickUpDate;
    private String dropDate;
    private Integer passangerCapacity;
    private Integer members;
    private Integer days;
    private Integer numBags;
    private Double totalPrice;
    @ManyToOne
    private Car car;
}
