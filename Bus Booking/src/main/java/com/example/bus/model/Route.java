package com.example.bus.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Route")
@AllArgsConstructor
@Data
@NoArgsConstructor

public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routid;
    @NonNull
    private String routefrom;

    @NonNull
    private String routeto;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    private List<Bus> busList = new ArrayList<>();

}
