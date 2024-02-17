package com.CarRental.repo;

import com.CarRental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,String> {
}
