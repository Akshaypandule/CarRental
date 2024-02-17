package com.CarRental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ATM {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Long cardNo;
    private String cardHolder;
    private LocalDate expDate;
    @Transient
    private Integer cvv;
}
