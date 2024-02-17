package com.CarRental.Controller;


import com.CarRental.dto.UserDto;
import com.CarRental.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("customer/auth/register")
@CrossOrigin
public class UserController
{

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto usersDto)
    {
        UserDto user = userService.createUser(usersDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
