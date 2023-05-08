package com.example.bus.controller;
import com.example.bus.model.Admin;
import com.example.bus.model.Traveler;
import com.example.bus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PutMapping("/update/admin")
    public String updateAdmin( @RequestBody Admin admin, @RequestParam String key )  {

         return adminService.updateAdmin(admin, key);

    }
    @PostMapping(path = "/admin/register")
    public Admin addAdmin(@RequestBody Admin admin)
    {
        return  adminService.addAdmin(admin);

    }

}
/*
{
    "adminname": "Doe",
    "adminpassword": "123",
    "email": "doe@gmail.com"
}
 */