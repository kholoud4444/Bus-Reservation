package com.example.bus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Data
@Table(name = "Bus")
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer busid;
    @NonNull
    private String busname;

    private String bustype;

    @NonNull
    private String routefrom;
    @NonNull
    private String routeto;
    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime departuretime;

    @NonNull
    private Integer seats;

    @NonNull
    private Integer availableseats;

    @NonNull
    private Integer fareperseat;

    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate busjourneydate;
    @JsonIgnore
    @ManyToOne
    private Route route;
}
