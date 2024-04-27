package com.example.flightticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightticket.model.Users;

public interface Repository_2  extends JpaRepository<Users,Integer>{
    Optional<Users> findByEmail(String username);

}
