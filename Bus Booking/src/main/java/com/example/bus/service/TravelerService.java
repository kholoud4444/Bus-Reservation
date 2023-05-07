package com.example.bus.service;
import com.example.bus.model.Admin;
import com.example.bus.model.Traveler;
import com.example.bus.reposetory.AdminRepository;
import com.example.bus.reposetory.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelerService {
    @Autowired
    private TravelerRepository travelerRepository;
    @Autowired
    private AdminRepository adminRepository;
    public Traveler AddTraveler(Traveler traveler){
        return travelerRepository.save(traveler);

    }

    public Object getAllTravelers(String adminpassword) {
        Admin admin = adminRepository.findByAdminpassword(adminpassword);
        if(admin == null) {
            return "Please provide a valid key to update Traveler Details!";
        }
        return travelerRepository.findAll();
    }

    public String updateTraveler(Traveler traveler, String username){
        Traveler user = travelerRepository.findByUsername(username);

        if(user == null) {
            return "Please provide a valid key to update Traveler Details!";
        }

        user.setUsername(traveler.getUsername());
        user.setEmail(traveler.getEmail());
        user.setPassword(traveler.getPassword());
        user.setPhone(traveler.getPhone());
        travelerRepository.save(user);


        return "Updated Succecfully!!";



    }
}
