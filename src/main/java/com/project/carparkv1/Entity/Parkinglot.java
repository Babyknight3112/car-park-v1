package com.project.carparkv1.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Parkinglot {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "parkId")
    private long parkId;
    @Basic
    @Column(name = "parkArea")
    private Long parkArea;
    @Basic
    @Column(name = "parkName", length = 50, nullable = false)
    private String parkName;
    @Basic
    @Column(name = "parkPlace", length = 50, nullable = false)
    private String parkPlace;
    @Basic
    @Column(name = "parkPrice")
    private Long parkPrice;
    @Basic
    @Column(name = "parkStatus", length = 50)
    private String parkStatus;
    @OneToMany(mappedBy = "parkinglotByIdPark")
    private Collection<Car> carsByParkId;

    public long getParkId() {
        return parkId;
    }

    public void setParkId(long parkId) {
        this.parkId = parkId;
    }

    public Long getParkArea() {
        return parkArea;
    }

    public void setParkArea(Long parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public Long getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(Long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parkinglot that = (Parkinglot) o;
        return parkId == that.parkId && Objects.equals(parkArea, that.parkArea) && Objects.equals(parkName, that.parkName) && Objects.equals(parkPlace, that.parkPlace) && Objects.equals(parkPrice, that.parkPrice) && Objects.equals(parkStatus, that.parkStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
    }

    public Collection<Car> getCarsByParkId() {
        return carsByParkId;
    }

    public void setCarsByParkId(Collection<Car> carsByParkId) {
        this.carsByParkId = carsByParkId;
    }
}
