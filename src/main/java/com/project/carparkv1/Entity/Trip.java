package com.project.carparkv1.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Trip {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tripId")
    private long tripId;
    @Basic
    @Column(name = "bookedTicketNumber")
    private Integer bookedTicketNumber;
    @Basic
    @Column(name = "carType", length = 50, nullable = false)
    private String carType;
    @Basic
    @Column(name = "departureDate", nullable = false)
    private LocalDate departureDate;
    @Basic
    @Column(name = "departureTime", nullable = false)
    private LocalTime departureTime;
    @Basic
    @Column(name = "destination", length = 50,nullable = false)
    private String destination;
    @Basic
    @Column(name = "driver", length = 50, nullable = false)
    private String driver;
    @Basic
    @Column(name = "maximumOnlineTicketNumber", nullable = false)
    private int maximumOnlineTicketNumber;
    @OneToMany(mappedBy = "tripByIdTrip")
    private Collection<Bookingoffice> bookingofficesByTripId;
    @OneToMany(mappedBy = "tripByTripId")
    private Collection<Ticket> ticketsByTripId;

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public Integer getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(Integer bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return tripId == trip.tripId && maximumOnlineTicketNumber == trip.maximumOnlineTicketNumber && Objects.equals(bookedTicketNumber, trip.bookedTicketNumber) && Objects.equals(carType, trip.carType) && Objects.equals(departureDate, trip.departureDate) && Objects.equals(departureTime, trip.departureTime) && Objects.equals(destination, trip.destination) && Objects.equals(driver, trip.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, bookedTicketNumber, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
    }

    public Collection<Bookingoffice> getBookingofficesByTripId() {
        return bookingofficesByTripId;
    }

    public void setBookingofficesByTripId(Collection<Bookingoffice> bookingofficesByTripId) {
        this.bookingofficesByTripId = bookingofficesByTripId;
    }

    public Collection<Ticket> getTicketsByTripId() {
        return ticketsByTripId;
    }

    public void setTicketsByTripId(Collection<Ticket> ticketsByTripId) {
        this.ticketsByTripId = ticketsByTripId;
    }
}
