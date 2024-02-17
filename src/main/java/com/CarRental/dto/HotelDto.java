package com.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {

    private String id;
    private String hotel;
    private String room;
    private Integer stay;
    private String manageParking;
    private Double finalCost;
}
