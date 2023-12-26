package com.example.tourgowebappfinalversion.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToursRepository extends JpaRepository<Tours, Long> {
    List<Tours> findByTitle(String title);
}
