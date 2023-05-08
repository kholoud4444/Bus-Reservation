package com.example.bus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationid;
    private String reservationstatus;

    private LocalDate reservationdate;
    private LocalTime reservationtime;
    private String source;
    private String destination;
    private LocalDate journeyDate;
    private Integer noofseatsbooked;
    private Integer fare;
    @JsonIgnore
    @ManyToOne
    private Bus bus;
    @JsonIgnore
    @ManyToOne
    private Traveler traveler;
}
