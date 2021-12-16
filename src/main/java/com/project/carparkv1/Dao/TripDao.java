package com.project.carparkv1.Dao;

import com.project.carparkv1.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDao extends JpaRepository<Trip, Long> {
    Trip findByDestination(String destination);
}
