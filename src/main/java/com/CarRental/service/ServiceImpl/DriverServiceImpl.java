package com.CarRental.service.ServiceImpl;

import com.CarRental.dto.DriverDto;
import com.CarRental.entity.Driver;
import com.CarRental.exception.ResourceNotFound;
import com.CarRental.repo.DriverRepository;
import com.CarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public DriverDto createDriver(DriverDto driverDto)
    {
        Driver driver = modelMapper.map(driverDto, Driver.class);
        Driver savedriver = driverRepository.save(driver);
        return modelMapper.map(savedriver, DriverDto.class) ;
    }

    @Override
    public DriverDto getSingleDriver(String id) {

        Driver findDriverId = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Driver id is not find"));
        return modelMapper.map(findDriverId, DriverDto.class);
    }

    @Override
    public List<DriverDto> getAllDriver() {
        List<DriverDto> driverDto = driverRepository.findAll()
                .stream().map(driver -> modelMapper.map(driver, DriverDto.class))
                .collect(Collectors.toList());
        return driverDto;
    }
}
