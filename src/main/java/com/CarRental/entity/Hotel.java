package com.CarRental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String hotel;
    private String room;
    private Integer stay;
    private String manageParking;
    private Double finalCost;
}
