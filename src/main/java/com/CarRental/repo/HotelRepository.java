package com.CarRental.repo;

import com.CarRental.dto.HotelDto;
import com.CarRental.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
