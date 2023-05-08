package com.example.bus.reposetory;

import com.example.bus.model.Admin;
import com.example.bus.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByAdminpassword(String adminpassword);
}
