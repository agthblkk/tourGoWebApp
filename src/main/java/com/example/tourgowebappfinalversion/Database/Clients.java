package com.example.tourgowebappfinalversion.Database;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    private Tours tour;

    public Clients(String name, String surname,
                          String phone, String email, Tours tour){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.tour = tour;
    }
}
