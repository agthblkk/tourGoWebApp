package com.example.tourgowebappfinalversion.Database;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class toConsultUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String format;
    private String name;
    private String surname;
    private String phone;
    private String email;

    public toConsultUsers(String format, String name, String surname,
                          String phone, String email){
        this.name = name;
        this.format = format;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

}
