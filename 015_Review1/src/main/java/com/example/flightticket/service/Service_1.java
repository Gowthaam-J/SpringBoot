package com.example.flightticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.flightticket.model.Booking;
import com.example.flightticket.repository.Repository_1;

import io.micrometer.common.lang.NonNull;
@Service
public class Service_1 {
    @Autowired
    public Repository_1 ab;
    public Booking createnewuser(@NonNull Booking user)
    {
        return ab.save(user);
    }
    public List<Booking> getAllusers()
    {
        return ab.findAll();
    }
    public Optional<Booking> getModelByEmail(  String email)
    {
        return ab.findByEmail(email);
    }
    public Booking updateUser(@NonNull Integer id,@RequestBody Booking user)
    {
        return ab.findById(id)
        .map(existingUser -> {
            existingUser.setEmail(user.getEmail());
        existingUser.setfrom(user.getfrom());
        existingUser.setdestination(user.getdestination());
        // existingUser.setfrom(user.getfrom());
        // existingUser.setType(user.getType());
        return ab.save(existingUser);
        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this email: "+ id));

    }
    public void removeUser(@NonNull Integer userId)
    {
        ab.deleteById(userId);
    }

    
}