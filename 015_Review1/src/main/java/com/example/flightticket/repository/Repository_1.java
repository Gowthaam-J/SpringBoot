package com.example.flightticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightticket.model.Booking;

public interface Repository_1  extends JpaRepository<Booking,Integer>{
    Optional<Booking> findByEmail(String username);
}
