package com.example.bus.controller;

import com.example.bus.model.Bus;
import com.example.bus.model.Route;
import com.example.bus.service.BusService;
import com.example.bus.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteController {
    @Autowired
    private RouteService routeService;
    @PostMapping("/route/admin")
    public String addRoute(@RequestBody Route route){

        return  routeService.addRoute(route);

    }
    @DeleteMapping("/route/admin/{routid}")
    public String DeleteRoute(@PathVariable("routid") Integer routid) {
        return routeService.deleteRoute(routid);
    }
    @GetMapping("/route/admin")
    public ResponseEntity<List<Route>> viewAllRoutes() {
        List<Route> routes = routeService.getAllRouts();

        if (routes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
    @PutMapping("/updaterout/admin")
    public String update(@RequestBody Route route, @RequestParam Integer key )  {

        return routeService.updateRoute(route, key);

    }
    @DeleteMapping ("Route/{routeid}")
    public Route viewRoute(@PathVariable int routeid ){
        return  routeService.viewRoute(routeid);
    }


}
