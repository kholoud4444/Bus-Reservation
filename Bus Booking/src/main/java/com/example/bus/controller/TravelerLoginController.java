package com.example.bus.controller;

import com.example.bus.model.Traveler;
import com.example.bus.service.TravelerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelerLoginController {

    @Autowired
    private TravelerLoginService travelerLoginService;
    @PostMapping("/user/login")
    public String loginUser(@RequestBody Traveler traveler) {
        return travelerLoginService.loginUser(traveler.getUsername(), traveler.getPassword());
    }

    @PostMapping("/user/logout")
    public String logoutAdmin(@RequestBody Traveler traveler){

        return travelerLoginService.logOutFromtravelerAccount(traveler.getUsername());

    }
}
