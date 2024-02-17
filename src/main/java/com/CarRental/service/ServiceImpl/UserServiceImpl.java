package com.CarRental.service.ServiceImpl;

import com.CarRental.dto.UserDto;
import com.CarRental.entity.Users;
import com.CarRental.repo.UserRepository;
import com.CarRental.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto)
    {
       // String dob = userDto.getDob();
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Users user1 = modelMapper.map(userDto, Users.class);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate date = LocalDate.parse(dob, dateTimeFormatter);
//        user1.setDob(date);
        Users user = userRepository.save(user1);
        return modelMapper.map(user, UserDto.class);
    }
}
