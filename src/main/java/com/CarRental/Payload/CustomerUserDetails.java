package com.CarRental.Payload;

import com.CarRental.entity.Users;
import com.CarRental.exception.ResourceNotFound;
import com.CarRental.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerUserDetails implements UserDetailsService {


        @Autowired
        private UserRepository userRepository;
//    @Autowired
//    private UserService userService;
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Users user= userRepository.findByEmail(username)
                    .orElseThrow(()->new ResourceNotFound("User name is not found"));
            return user;
        }

}
