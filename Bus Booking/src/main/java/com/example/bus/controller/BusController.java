package com.example.bus.controller;
import com.example.bus.model.Bus;
import com.example.bus.model.Reservation;
import com.example.bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {
    @Autowired
    private BusService busService;
    @PostMapping("/bus/admin")
    public String addBus(@RequestBody Bus bus){

        return  busService.addBus(bus);

    }
    @DeleteMapping("/bus/admin/{busId}")
    public String DeleteBus(@PathVariable("busId") Integer busId) {
        return busService.deleteBus(busId);
    }
    @GetMapping("/buses/admin")
    public ResponseEntity<List<Bus>> viewAllBuses() {
        List<Bus> buses = busService.getAllBuses();

        if (buses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(buses, HttpStatus.OK);
    }
    @PutMapping("/updateBus/admin")
    public String update(@RequestBody Bus bus, @RequestParam String key )  {

        return busService.updateBus(bus, key);

    }
    @GetMapping("/user/route/buses")
    public Object viewBusesByRoateId(@RequestParam(required = false) Integer key){

            return busService.viewBusesByRoateId(key);
        }


}
/*
{
    "busname": "AcmeBus",
    "bustype": "Luxury",
    "routefrom": "faioum",
    "routeto": "giaza",
    "departuretime": "12:00",
    "seats": 50,
    "availableseats": 50,
    "fareperseat": 50,
    "busjourneydate": "2023-05-10"
}
 */