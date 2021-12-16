package com.project.carparkv1.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

@Data
@Entity
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticketId")
    private long ticketId;
    @Basic
    @Column(name = "bookingTime")
    private LocalTime bookingTime;
    @Basic
    @Column(name = "customerName", length = 50, nullable = false)
    private String customerName;
    @Basic
    @Column(name = "plate_license", length = 20, nullable = false)
    private String plateLicense;
    @Basic
    @Column(name = "trip_id", length = 20)
    private Long tripId;
    @ManyToOne(optional=false)
    @JoinColumn(name = "plate_license", referencedColumnName = "licensePlate", insertable=false, updatable=false)
    private Car carByPlateLicense;
    @ManyToOne(optional=false)
    @JoinColumn(name = "trip_id", referencedColumnName = "tripId", insertable=false, updatable=false)
    private Trip tripByTripId;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPlateLicense() {
        return plateLicense;
    }

    public void setPlateLicense(String plateLicense) {
        this.plateLicense = plateLicense;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId && Objects.equals(bookingTime, ticket.bookingTime) && Objects.equals(customerName, ticket.customerName) && Objects.equals(plateLicense, ticket.plateLicense) && Objects.equals(tripId, ticket.tripId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, bookingTime, customerName, plateLicense, tripId);
    }

    public Car getCarByPlateLicense() {
        return carByPlateLicense;
    }

    public void setCarByPlateLicense(Car carByPlateLicense) {
        this.carByPlateLicense = carByPlateLicense;
    }

    public Trip getTripByTripId() {
        return tripByTripId;
    }

    public void setTripByTripId(Trip tripByTripId) {
        this.tripByTripId = tripByTripId;
    }
}
