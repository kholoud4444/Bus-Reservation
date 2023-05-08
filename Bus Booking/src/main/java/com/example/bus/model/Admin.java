package com.example.bus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Table(name = "admin")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull

    private String adminname;

    @NonNull
    @Column(name ="adminpassword",unique = true )
    private String adminpassword;


    private String email;
}
