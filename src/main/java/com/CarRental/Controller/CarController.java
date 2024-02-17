package com.CarRental.Controller;
import com.CarRental.dto.CarDto;
import com.CarRental.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("customer/auth/cars/")
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto)
    {
        CarDto carDto1 = carService.addCar(carDto);
        return new ResponseEntity<>(carDto1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CarDto>> viewAllCar()
    {
        List<CarDto> allCar = carService.getAllCar();
        return new ResponseEntity<List<CarDto>>(allCar,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable String id){
        CarDto singleCar = carService.getSingleCar(id);
        return new ResponseEntity<>(singleCar,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable String id){
        carService.deleteCar(id);
        return "Car delete Successfully";
    }
}
