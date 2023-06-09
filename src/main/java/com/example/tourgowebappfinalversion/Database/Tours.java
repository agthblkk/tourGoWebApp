package com.example.tourgowebappfinalversion.Database;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor

public class Tours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String date;
    private int availableSeatsNum;
//    @OneToOne(mappedBy = "tourId", cascade = CascadeType.ALL)
//    @JoinColumn(name = "tourId", referencedColumnName = "id")
//    private Clients client;
    @OneToMany(mappedBy = "tour")
    private List<Clients> clients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailableSeatsNum() {
        return availableSeatsNum;
    }

    public void setAvailableSeatsNum(int availableSeatsNum) {
        this.availableSeatsNum = availableSeatsNum;
    }

    public Tours(String title, String date, int availableSeatsNum){
        this.title = title;
        this.date = date;
        this.availableSeatsNum = availableSeatsNum;
    }
}
