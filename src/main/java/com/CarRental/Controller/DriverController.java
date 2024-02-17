package com.CarRental.Controller;

import com.CarRental.dto.DriverDto;
import com.CarRental.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("customer/auth/drivers/")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<DriverDto>createUser(@RequestBody DriverDto driverDto){

        DriverDto driver = driverService.createDriver(driverDto);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable String id ){

        DriverDto singleDriver = driverService.getSingleDriver(id);
        System.out.println(singleDriver.getCharges());
        return new ResponseEntity<>(singleDriver,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<DriverDto>> getAllDriver()
    {
        List<DriverDto> allDriver = driverService.getAllDriver();
        return new ResponseEntity<>(allDriver,HttpStatus.OK);

    }
}
