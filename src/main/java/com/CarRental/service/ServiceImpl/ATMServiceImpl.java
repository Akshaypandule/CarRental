package com.CarRental.service.ServiceImpl;

import com.CarRental.dto.ATMDto;
import com.CarRental.entity.ATM;
import com.CarRental.exception.ResourceNotFound;
import com.CarRental.repo.AtmRepository;
import com.CarRental.service.ATMService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
@Service
public class ATMServiceImpl implements ATMService {
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private AtmRepository atmRepository;
    @Override
    public ATMDto createATM(ATMDto atmDto)
    {
        String expDate = atmDto.getExpDate();
//        LocalDate localdate = LocalDate.parse(expDate, DateTimeFormatter.ofPattern("MM/yy"));
        ATM atm = modelMapper.map(atmDto, ATM.class);
//        atm.setExpDate(localdate);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/yy");
        LocalDate localDate = YearMonth.parse(expDate, dateTimeFormatter).atEndOfMonth();
        atm.setExpDate(localDate);
        ATM save = atmRepository.save(atm);
        ATMDto atmDto1 = modelMapper.map(save, ATMDto.class);
        return atmDto1;
    }

    @Override
    public ATMDto getAtmById(String id)
    {
        ATM atmid = atmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Id is not found "));
        return modelMapper.map(atmid,ATMDto.class);
    }
}
