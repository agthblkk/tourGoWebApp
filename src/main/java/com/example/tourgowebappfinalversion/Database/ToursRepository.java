package com.example.tourgowebappfinalversion.Database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToursRepository extends JpaRepository<Tours, Long> {
    List<Tours> findByTitle(String title);
}
