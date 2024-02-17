package com.CarRental.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{

    private String id;
    @NotBlank(message = "First name must be required")
    private String fname;
    @NotBlank(message = "last name must be required")
    private String lname;
    @Past(message = "date of birth must be past")
    @NotBlank(message = "Enter the dob")
    private LocalDate dob;
    @NotBlank(message = "Please enter the email")
    private String email;
    @NotBlank(message = "Password must be required")
    @Size(min=8,max=15)
    private String password;
}
