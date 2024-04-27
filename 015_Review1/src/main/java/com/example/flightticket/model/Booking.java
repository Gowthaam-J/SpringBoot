package com.example.flightticket.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="User")
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String source;
    private String destination;
    public int getBooking_id() {
        return id;
    }
    public void setBooking_id(int id) {
        this.id= id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getfrom() {
        return source;
    }
    public void setfrom(String source) {
        this.source = source;
    }
    public String getdestination() {
        return destination;
    }
    public void setdestination(String to) {
        destination = to;
    }
    public Booking(int id, String email,String source,String destination) {
        this.id = id;
        this.email = email;
        this.source = source;
        this.destination=destination;
    }
    public Booking() {
    }
    
}

