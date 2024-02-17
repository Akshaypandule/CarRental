package com.CarRental.service.ServiceImpl;

import com.CarRental.dto.CarDto;
import com.CarRental.entity.Car;
import com.CarRental.exception.ResourceNotFound;
import com.CarRental.repo.CarRepository;
import com.CarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CarRepository carRepository;
    @Override
    public CarDto addCar(CarDto carDto)
    {

        Car car = modelMapper.map(carDto, Car.class);
        String string = UUID.randomUUID().toString();
        car.setId(string);
        Car save = carRepository.save(car);
        return modelMapper.map(save,CarDto.class);
    }

    @Override
    public CarDto getSingleCar(String id)
    {
        Car carId = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Car Id is Not Found"));
        CarDto cardto = modelMapper.map(carId, CarDto.class);
        return cardto;
    }

    @Override
    public List<CarDto> getAllCar()
    {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDto = cars.stream().map(car -> modelMapper.map(car, CarDto.class)).collect(Collectors.toList());
        return carDto;
    }

    @Override
    public void deleteCar(String id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Id is Not found"));
        carRepository.delete(car);
    }
}
