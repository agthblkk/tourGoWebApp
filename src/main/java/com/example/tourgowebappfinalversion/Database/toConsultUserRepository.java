package com.example.tourgowebappfinalversion.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface toConsultUserRepository  extends JpaRepository<toConsultUser, Long> {
}
