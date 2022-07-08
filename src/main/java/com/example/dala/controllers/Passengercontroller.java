package com.example.dala.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.example.dala.models.Passenger;
import com.example.dala.repositories.Passengerrepo;

@RestController
public class Passengercontroller {
    @Autowired
    private Passengerrepo passengerrepo;

    @GetMapping("/passenger")
    public List<Passenger>getAll(){
        return passengerrepo.findAll();
    }

    @GetMapping("/passenger{id}")
    public Optional <Passenger> findById(@PathVariable int id){
        return passengerrepo.findById(id);
    }

    @PostMapping("/passenger")
    public Passenger newPassenger(@RequestBody Passenger newPassenger){
        return passengerrepo.save(newPassenger);

    }

    @DeleteMapping("/passenger/{id}")
    public void deletePassenger(@PathVariable int id){
        passengerrepo.deleteById(id);
    }
    @PutMapping("/passenger/{id}")
    public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger replacePassenger){
        if(passengerrepo.findById(replacePassenger.getId()).isPresent()){
            return new ResponseEntity<Passenger>(passengerrepo.save(replacePassenger),HttpStatus.OK);
        }
        else{
            return new ResponseEntity(replacePassenger,HttpStatus.BAD_REQUEST);
        }
    }
}

