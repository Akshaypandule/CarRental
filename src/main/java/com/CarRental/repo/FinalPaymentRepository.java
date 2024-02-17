package com.CarRental.repo;

import com.CarRental.dto.FinalPaymentDto;
import com.CarRental.entity.FinalPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinalPaymentRepository extends JpaRepository<FinalPayment,String> {

    List<FinalPayment> findByEmail (String emali);
}
