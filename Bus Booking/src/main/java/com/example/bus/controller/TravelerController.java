package com.example.bus.controller;
import com.example.bus.model.Admin;
import com.example.bus.model.Traveler;
import com.example.bus.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TravelerController {
    @Autowired
    private TravelerService travelerService;
    @PostMapping(path = "/user/register")
    public Traveler AddTraveler(@RequestBody Traveler traveler)
    {
        return  travelerService.AddTraveler(traveler);

    }

    @GetMapping("/admin/travellers")
    public ResponseEntity<List<Traveler>> getAllTravelers(@RequestParam String key) {
        List<Traveler> travelers = (List<Traveler>) travelerService.getAllTravelers(key);

        if (travelers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(travelers, HttpStatus.OK);
    }
    @PutMapping("/update/traveler")
    public String updateTraveler(@RequestBody Traveler traveler, @RequestParam String key )  {

        return travelerService.updateTraveler(traveler, key);

    }

}

