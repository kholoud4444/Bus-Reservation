package com.example.bus.controller;

import com.example.bus.model.Reservation;
import com.example.bus.model.Traveler;
import com.example.bus.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @PostMapping("/reservation/user")
    public String addReservation(@RequestBody Reservation reservation, @RequestParam(required = false) Integer key, @RequestParam(required = false) Integer key2) {

        return reservationService.addReservation(reservation,key,key2);

    }
    @DeleteMapping("/reservation/user/{id}")
    public String deleteReservation(@PathVariable("id") Integer reservationId,@RequestParam(required = false) Integer key ) {
        return reservationService.deleteReservation(reservationId,key);
    }

    @GetMapping("/reservation/ViewReseRvedUser")

    public Object viewReservationByUser(@RequestParam(required = false) Integer key) {

       return reservationService.viewReservationByUser(key);
    }
    }


