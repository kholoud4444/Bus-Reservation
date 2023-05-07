package com.example.bus.service;

import com.example.bus.model.Bus;
import com.example.bus.model.Route;
import com.example.bus.reposetory.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusService busService;
    @Autowired
    private AdminService adminService;
    public String addRoute(Route route)  {

        Route route1=routeRepository.findByRoutefromAndRouteto(route.getRoutefrom(), route.getRouteto());

        if(route1 != null) {
            return "already present!";
        }

        List<Bus> buses = new ArrayList<>();

        if(route != null) {
            route.setBusList(buses);
             routeRepository.save(route);
             return "Added Successfully!!";
        }
        return "Not Found";
    }
    public String deleteRoute(Integer routid) {
        Optional<Route> route=routeRepository.findById(routid);
        if(route.isPresent()) {
            Route existingRout = route.get();
            routeRepository.delete(existingRout);
            return "Deleted Successfully!!";
        }
        else
            return "Bus doesn't exist with busId ";

    }
    public List<Route> getAllRouts() {
        return routeRepository.findAll();
    }
    public String updateRoute(Route route,Integer routid) {


        Optional<Route> existedRoute = routeRepository.findById(route.getRoutid());
        if(existedRoute.isPresent()) {
            Route presentRoute = existedRoute.get();
            List<Bus> busList = presentRoute.getBusList();

            if(!busList.isEmpty())
                return "Cannot update running route! Buses are already scheduled in the route.";
            presentRoute.setRouteto(route.getRouteto());
            presentRoute.setRoutefrom(route.getRoutefrom());
            routeRepository.save(presentRoute);
            return "Updated Succecfully!!";

        }
        else
            return "Route doesn't exist!! ";

    }
}
