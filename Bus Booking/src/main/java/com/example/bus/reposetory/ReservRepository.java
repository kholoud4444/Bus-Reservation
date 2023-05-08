package com.example.bus.reposetory;

import com.example.bus.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ReservRepository extends JpaRepository<Reservation,Integer> {
}
