package com.project.carparkv1.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
public class Bookingoffice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "officeId")
    private long officeId;
    @Basic
    @Column(name = "endContractDeadline")
    private LocalDate endContractDeadline;
    @Basic
    @Column(name = "officeName", length = 50, nullable = false)
    private String officeName;
    @Basic
    @Column(name = "officePhone", length = 10, nullable = false)
    private String officePhone;
    @Basic
    @Column(name = "officePlace", length = 50)
    private String officePlace;
    @Basic
    @Column(name = "officePrice", nullable = false)
    private long officePrice;
    @Basic
    @Column(name = "startContractDeadline")
    private LocalDate startContractDeadline;
    @Basic
    @Column(name = "id_trip")
    private Long idTrip;
    @ManyToOne(optional=false)
    @JoinColumn(name = "id_trip", referencedColumnName = "tripId", insertable=false, updatable=false)
    private Trip tripByIdTrip;

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public LocalDate getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(LocalDate endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public long getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(long officePrice) {
        this.officePrice = officePrice;
    }

    public LocalDate getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(LocalDate startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public Long getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(Long idTrip) {
        this.idTrip = idTrip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookingoffice that = (Bookingoffice) o;
        return officeId == that.officeId && officePrice == that.officePrice && Objects.equals(endContractDeadline, that.endContractDeadline) && Objects.equals(officeName, that.officeName) && Objects.equals(officePhone, that.officePhone) && Objects.equals(officePlace, that.officePlace) && Objects.equals(startContractDeadline, that.startContractDeadline) && Objects.equals(idTrip, that.idTrip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeId, endContractDeadline, officeName, officePhone, officePlace, officePrice, startContractDeadline, idTrip);
    }

    public Trip getTripByIdTrip() {
        return tripByIdTrip;
    }

    public void setTripByIdTrip(Trip tripByIdTrip) {
        this.tripByIdTrip = tripByIdTrip;
    }
}
