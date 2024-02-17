package com.CarRental.Controller;


import com.CarRental.dto.ATMDto;
import com.CarRental.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("atm/")
public class AtmController {

    @Autowired
    private ATMService atmService;

    @PostMapping
    public ResponseEntity<ATMDto> createAtm(@RequestBody ATMDto  atmDto){
        ATMDto atm = atmService.createATM(atmDto);
        return new ResponseEntity<>(atm, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ATMDto> getSingleAtm(@PathVariable String id){
        ATMDto atmById = atmService.getAtmById(id);
        return new ResponseEntity<>(atmById,HttpStatus.OK);
    }
}
