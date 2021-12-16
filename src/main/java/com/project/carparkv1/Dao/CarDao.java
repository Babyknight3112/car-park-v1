package com.project.carparkv1.Dao;

import com.project.carparkv1.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends JpaRepository<Car, String> {
}
