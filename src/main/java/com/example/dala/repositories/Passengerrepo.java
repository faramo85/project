package com.example.dala.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dala.models.Passenger;

public interface Passengerrepo extends JpaRepository<Passenger, Integer>{
    
}
