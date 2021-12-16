package com.project.carparkv1.Dao;

import com.project.carparkv1.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Long> {

    List<Ticket> findByPlateLicense(String plateLicense);

    List<Ticket> findByCustomerName(String customerName);
}
