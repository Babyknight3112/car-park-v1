package com.project.carparkv1.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Car {
    @Id
    @Column(name = "licensePlate", length = 20)
    private String licensePlate;
    @Basic
    @Column(name = "carColor", length = 11, nullable = false)
    private String carColor;
    @Basic
    @Column(name = "carType", length = 30)
    private String carType;
    @Basic
    @Column(name = "company", length = 30)
    private String company;
    @Basic
    @Column(name = "id_park")
    private Long idPark;
    @ManyToOne(optional=false)
    @JoinColumn(name = "id_park", referencedColumnName = "parkId", insertable=false, updatable=false)
    private Parkinglot parkinglotByIdPark;
    @OneToMany(mappedBy = "carByPlateLicense")
    private Collection<Ticket> ticketsByLicensePlate;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getIdPark() {
        return idPark;
    }

    public void setIdPark(Long idPark) {
        this.idPark = idPark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(licensePlate, car.licensePlate) && Objects.equals(carColor, car.carColor) && Objects.equals(carType, car.carType) && Objects.equals(company, car.company) && Objects.equals(idPark, car.idPark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, carColor, carType, company, idPark);
    }

    public Parkinglot getParkinglotByIdPark() {
        return parkinglotByIdPark;
    }

    public void setParkinglotByIdPark(Parkinglot parkinglotByIdPark) {
        this.parkinglotByIdPark = parkinglotByIdPark;
    }

    public Collection<Ticket> getTicketsByLicensePlate() {
        return ticketsByLicensePlate;
    }

    public void setTicketsByLicensePlate(Collection<Ticket> ticketsByLicensePlate) {
        this.ticketsByLicensePlate = ticketsByLicensePlate;
    }
}
