package com.example.bus.controller;

import com.example.bus.model.Admin;
import com.example.bus.model.Traveler;
import com.example.bus.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminLoginController {
    @Autowired
    private AdminLoginService adminLoginService;
    @PostMapping("/login/admin")
    public String loginAdmin(@RequestBody Admin admin) {

        return adminLoginService.loginAdmin(admin.getAdminpassword());
    }
    @PostMapping("/admin/logout")
    public String logoutAdmin(@RequestBody Admin admin){

        return adminLoginService.logOutFromAdminAccount(admin.getAdminpassword());

    }
}
