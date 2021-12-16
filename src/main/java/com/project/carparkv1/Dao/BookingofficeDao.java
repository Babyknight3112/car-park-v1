package com.project.carparkv1.Dao;

import com.project.carparkv1.Entity.Bookingoffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingofficeDao extends JpaRepository<Bookingoffice, Long> {
    List<Bookingoffice> findByOfficeName(String officeName);
}
