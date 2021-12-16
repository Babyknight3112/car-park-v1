package com.project.carparkv1.Dao;

import com.project.carparkv1.Entity.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkinglotDao extends JpaRepository<Parkinglot, Long> {

    Optional<Parkinglot> findByParkName(String parkName);

    Parkinglot findByParkPlace(String parkPlace);

    List<Parkinglot> findByParkPrice(Long parkPrice);
}
