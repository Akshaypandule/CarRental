package com.CarRental.dto;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ATMDto {
    private String id;
    private Long cardNo;
    private String cardHolder;
    private String expDate;
    private Integer cvv;
}
