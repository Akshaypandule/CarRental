package com.CarRental.service;

import com.CarRental.dto.ATMDto;

public interface ATMService {

    ATMDto createATM(ATMDto atmDto);

    ATMDto getAtmById(String id);
}
