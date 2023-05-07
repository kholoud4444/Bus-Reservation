package com.example.bus.service;

import com.example.bus.model.Traveler;
import com.example.bus.reposetory.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelerLoginService {
    @Autowired
    private TravelerRepository travelerRepository;
    public String loginUser(String username, String password) {
        Traveler user = travelerRepository.findByUsername(username);
        if (user == null) {
            return "User not found";
        }
        if (!password.equals(user.getPassword())) {
            return "Invalid password";
        }
        return user.getUsername();
    }
    public String logOutFromtravelerAccount(String username)  {
        Traveler user = travelerRepository.findByUsername(username);
        if (user == null) {
            return "User not found";
        }

        else {
            travelerRepository.delete(user);

            return "Traveler Logged Out !";
        }
    }
}
