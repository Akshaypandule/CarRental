package com.CarRental.Controller;

import com.CarRental.Payload.CustomerUserDetails;
import com.CarRental.Payload.JwtAuthRequest;
import com.CarRental.Payload.JwtAuthResponse;
import com.CarRental.Security.JwtHelper;
import com.CarRental.entity.Users;
import com.CarRental.exception.ResourceNotFound;
import com.CarRental.repo.UserRepository;
import com.CarRental.service.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/auth/login")
public class AuthController {

    @Autowired
    private JwtHelper jwtTokenHelper;

    @Autowired
    private CustomerUserDetails customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userService;

    @Autowired

    private UserRepository userRepository;


    @PostMapping
    public ResponseEntity<Map<String,Object>> createToken(@RequestBody JwtAuthRequest request) throws Exception {

        authenticate(request.getEmail(),request.getPassword());

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getEmail());
        String generatedToken = jwtTokenHelper.generateToken(userDetails);

        Optional<Users> user= userRepository.findByEmail(request.getEmail());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(generatedToken);
        Map<String,Object> map=new HashMap<>();
        map.put("user",user);
        map.put("token",generatedToken);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    private void authenticate(String userName, String password) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);

        try {
            authenticationManager.authenticate(authenticationToken);
        }catch (BadCredentialsException ex){
            throw new ResourceNotFound("Invalid username and password");
        }

    }

}
