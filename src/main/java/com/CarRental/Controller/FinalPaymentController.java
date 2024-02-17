package com.CarRental.Controller;

import com.CarRental.dto.FinalPaymentDto;
import com.CarRental.service.FinalPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/auth/finalPayment/")
@CrossOrigin
public class FinalPaymentController {

    @Autowired
    private FinalPaymentService finalPaymentService;

    @PostMapping
    public ResponseEntity<FinalPaymentDto> createTicket(@RequestBody FinalPaymentDto finalPaymentDto){

        FinalPaymentDto finalPaymentDto1 = finalPaymentService.makeFinalPayment(finalPaymentDto);
        return new ResponseEntity<>(finalPaymentDto1, HttpStatus.CREATED);
    }

    @GetMapping("{email}")
    public ResponseEntity<List<FinalPaymentDto>> getAllBooking(@PathVariable String email){

        List<FinalPaymentDto> byEmail = finalPaymentService.findByEmail(email);
        return new ResponseEntity<>(byEmail,HttpStatus.OK);
    }
}
