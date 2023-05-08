package com.example.bus.service;

import com.example.bus.model.Admin;
import com.example.bus.model.Traveler;
import com.example.bus.reposetory.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {
    @Autowired
    private AdminRepository adminRepository;
    public String loginAdmin( String adminpassword) {
        Admin user = adminRepository.findByAdminpassword(adminpassword);
        if (user == null) {
            return "User not found";
        }

        return user.getAdminname();
    }
    public String logOutFromAdminAccount(String adminpassword)  {
        Admin admin = adminRepository.findByAdminpassword(adminpassword);
        if (admin == null) {
            return "Admin not found";
        }

        else {
            adminRepository.delete(admin);

            return "Admin Logged Out !";
        }
    }
}
