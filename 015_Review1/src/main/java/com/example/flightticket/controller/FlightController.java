package com.example.flightticket.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightticket.model.Booking;
import com.example.flightticket.service.Service_1;

import lombok.NonNull;


@RestController
@RequestMapping("/api/bookings")
public class FlightController {
    
@Autowired
private  Service_1 userService;

@PostMapping("/createUser")

public ResponseEntity<Booking> createUser(@NonNull @RequestBody Booking user) {

Booking createdUser = userService.createnewuser(user);

return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

}

@GetMapping("readUser/{email}")

public ResponseEntity<?> getUserByEmail(@PathVariable String email)
{

Optional<Booking> user = userService.getModelByEmail(email);

return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))

.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

}

@GetMapping("/readUsers")
public ResponseEntity<List<Booking>> getAllUsers()
{

List<Booking> users = userService.getAllusers();

return new ResponseEntity<>(users, HttpStatus.OK);

}

@PutMapping("updateUser/{email}")

public ResponseEntity<Booking> updateUser(@NonNull @PathVariable Integer id,@RequestBody Booking updateRequest)
{

Booking    updated = userService.updateUser(id, updateRequest);

return new ResponseEntity<>(updated, HttpStatus.OK);

}

@DeleteMapping("deleteUser/{userId}")

public ResponseEntity<Void> removeUser(@NonNull @PathVariable Integer userId) {

userService.removeUser(userId);

return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}

}