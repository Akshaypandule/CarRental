package com.CarRental.service.ServiceImpl;

import com.CarRental.dto.FinalPaymentDto;
import com.CarRental.entity.FinalPayment;
//import com.CarRental.repo.FinalPaymentRepository;
import com.CarRental.repo.FinalPaymentRepository;
import com.CarRental.service.FinalPaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinalPaymentImpl implements FinalPaymentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FinalPaymentRepository finalPaymentRepository;
    @Override
    public FinalPaymentDto makeFinalPayment(FinalPaymentDto finalPaymentDto)
    {
        FinalPayment map = modelMapper.map(finalPaymentDto, FinalPayment.class);
        FinalPayment finalBooking = finalPaymentRepository.save(map);
        return modelMapper.map(finalBooking,FinalPaymentDto.class);
    }
    @Override
    public List<FinalPaymentDto> findByEmail(String email)
    {
        List<FinalPayment> finalPayments = finalPaymentRepository.findByEmail(email);

        List<FinalPaymentDto> collect = finalPayments.stream().map(a1 -> modelMapper.map(a1, FinalPaymentDto.class))
                .collect(Collectors.toList());

        return collect;
    }
}
