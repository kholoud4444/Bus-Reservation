package com.example.bus.reposetory;

import com.example.bus.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface BusRepository extends JpaRepository<Bus, Integer> {
     Bus findByBustype(String bustype);

}
