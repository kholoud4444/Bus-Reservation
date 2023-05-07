package com.example.bus.service;

import com.example.bus.model.Admin;
import com.example.bus.model.Traveler;
import com.example.bus.reposetory.AdminRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public String updateAdmin(Admin admin, String adminpassword){

        Admin user = adminRepository.findByAdminpassword(adminpassword);

        if(user == null) {
            return "Please provide a valid key to update Admin Details!";
        }

        user.setAdminname(admin.getAdminname());
        user.setEmail(admin.getEmail());
        user.setAdminpassword(admin.getAdminpassword());

        adminRepository.save(user);


        return "Updated Succecfully!!";


    }
    public Admin AddAdmin(Admin admin){
        return adminRepository.save(admin);

    }
}
