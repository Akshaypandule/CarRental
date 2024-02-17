package com.CarRental.service;

import com.CarRental.dto.FinalPaymentDto;

import java.util.List;

public interface FinalPaymentService {

    FinalPaymentDto makeFinalPayment(FinalPaymentDto finalPaymentDto);

    List<FinalPaymentDto> findByEmail(String email);
}
