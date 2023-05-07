package com.example.bus.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Traveler implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @NonNull
    private int id;
    @NonNull
    @Column(name = "username")
    private String username;
    @NonNull
    @Column(name = "email")
    private String email;
    @NonNull

    @Column(name = "password",unique = true)
    private String password;
    @Column(name = "phone")

    private String phone;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "traveler")
    private List<Reservation> reservations =new ArrayList<>();




}
