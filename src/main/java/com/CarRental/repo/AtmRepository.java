package com.CarRental.repo;

import com.CarRental.entity.ATM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmRepository extends JpaRepository<ATM ,String> {
}
