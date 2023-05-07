package com.example.bus.service;

import com.example.bus.model.*;
import com.example.bus.reposetory.BusRepository;
import com.example.bus.reposetory.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
@Autowired
private RouteRepository routeRepository;
    public String addBus(Bus bus)  {

        Route route=routeRepository.findByRoutefromAndRouteto(bus.getRoutefrom(), bus.getRouteto());

        if(route != null) {
            route.getBusList().add(bus);
            bus.setRoute(route);
             busRepository.save(bus);
             return "Added Successfully!!";
        }
        else
            return "Bus detail is not correct";
    }
    public String deleteBus(Integer busId) {


        Optional<Bus> bus=busRepository.findById(busId);


        if(bus.isPresent()) {
            Bus existingBus = bus.get();
            busRepository.delete(existingBus);

            return "Deleted Successfully!!";
        }
        else
            return "Bus doesn't exist with busId ";

    }
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
    public String updateBus(Bus bus, String bustype){

        Bus user = busRepository.findByBustype(bustype);
        Route route=routeRepository.findByRoutefromAndRouteto(bus.getRoutefrom(), bus.getRouteto());

        if(user == null||route==null) {
            return "Please provide a valid data";
        }
        user.setBustype(bus.getBustype());
        user.setBusname(bus.getBusname());
        user.setDeparturetime(bus.getDeparturetime());
        user.setRoutefrom(bus.getRoutefrom());
        user.setRouteto(bus.getRouteto());
        user.setSeats(bus.getSeats());
        user.setFareperseat(bus.getFareperseat());

        busRepository.save(user);


        return "Updated Succecfully!!";



    }

}
