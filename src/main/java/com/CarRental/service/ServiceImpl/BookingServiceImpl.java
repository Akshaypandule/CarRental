package com.CarRental.service.ServiceImpl;

import com.CarRental.dto.BookingDto;
import com.CarRental.dto.BookingResponse;
import com.CarRental.entity.Booking;
import com.CarRental.entity.Car;
import com.CarRental.exception.ResourceNotFound;
import com.CarRental.repo.BookingRepository;
import com.CarRental.repo.CarRepository;
import com.CarRental.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CarRepository carRepository;
    @Override
    public BookingResponse createBooking(BookingDto bookingDto) {

        Car car = carRepository.findById(bookingDto.getCarId())
                .orElseThrow(() -> new ResourceNotFound("Car id is not found"));


        Booking booking=new Booking();
        BookingResponse b1=new BookingResponse();

        booking.setCar(car);
        // TotalPrice
        booking.setTotalPrice(bookingDto.getDays() * booking.getCar().getCharge());
        BeanUtils.copyProperties(bookingDto,booking);
//        booking.setPickUpLocation(bookingDto.getPickUpLocation());
//        booking.setDropLocation(bookingDto.getDropLocation());
//        booking.setPickUpTime(bookingDto.getPickUpTime());
//        booking.setPickUpDate(bookingDto.getPickUpDate());
//        booking.setDropDate(bookingDto.getDropDate());
//        booking.setPassangerCapacity(bookingDto.getPassangerCapacity());
//        booking.setNumBags(bookingDto.getNumBags());
//        booking.setMembers(bookingDto.getMembers());
//        booking.setDays(bookingDto.getDays());
//        booking.setCar(car);
//        // TotalPrice
//        booking.setTotalPrice(bookingDto.getDays() * booking.getCar().getCharge());
        Booking saveBooking = bookingRepository.save(booking);
        BeanUtils.copyProperties(saveBooking,b1);
        BeanUtils.copyProperties(car,b1);
        return b1;
    }
    @Override
    public BookingResponse getBooking(String id) {
        return null;
    }
}
