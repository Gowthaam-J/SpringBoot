package com.example.flightticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightticket.model.Users;
import com.example.flightticket.service.Service_1;

import lombok.NonNull;


@RestController
@RequestMapping("/api/profiles")
public class FlightController2 {
    
@Autowired
private  Service_1 userService;

@PostMapping("/createUser")

public ResponseEntity<Users> createUser(@NonNull @RequestBody Users user) {

Users createdUser = userService.createnewuser2(user);

return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

}

@GetMapping("/readUsers")
public ResponseEntity<List<Users>> getAllUsers()
{

List<Users> users = userService.getAllusers2();

return new ResponseEntity<>(users, HttpStatus.OK);

}


@DeleteMapping("deleteUser/{userId}")

public ResponseEntity<Void> removeUser(@NonNull @PathVariable Integer userId) {

userService.removeUser2(userId);

return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}

}