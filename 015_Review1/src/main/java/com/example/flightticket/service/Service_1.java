package com.example.flightticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.flightticket.model.Booking;
import com.example.flightticket.model.Users;
import com.example.flightticket.repository.Repository_1;
import com.example.flightticket.repository.Repository_2;

import io.micrometer.common.lang.NonNull;
@Service
public class Service_1 {
    @Autowired
    public Repository_1 ab;
    public Repository_2 ab2;
    public Booking createnewuser(@NonNull Booking user)
    {
        return ab.save(user);
    }
    public Users createnewuser2(@NonNull Users user2)
    {
        return ab2.save(user2);
    }
    public List<Booking> getAllusers()
    {
        return ab.findAll();
    }
    public List<Users> getAllusers2()
    {
        return ab2.findAll();
    }
    public Optional<Booking> getModelByEmail(  String email)
    {
        return ab.findByEmail(email);
    }
    public Optional<Users> getModelByEmail2(  String email2)
    {
        return ab2.findByEmail(email2);
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
    public Users updateUser2(@NonNull Integer id2,@RequestBody Users user)
    {
        return ab2.findById(id2)
        .map(existingUser -> {
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
        return ab2.save(existingUser);
        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this email: "+ id2));

    }
    public void removeUser(@NonNull Integer userId)
    {
        ab.deleteById(userId);
    }
    public void removeUser2(@NonNull Integer userId)
    {
        ab2.deleteById(userId);
    }

    
}