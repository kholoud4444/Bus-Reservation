package com.example.bus.reposetory;
import com.example.bus.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RouteRepository  extends JpaRepository<Route, Integer> {
    public Route findByRoutefromAndRouteto(String from,String to);
}
