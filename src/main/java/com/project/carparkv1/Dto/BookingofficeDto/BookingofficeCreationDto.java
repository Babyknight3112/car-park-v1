package com.project.carparkv1.Dto.BookingofficeDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingofficeCreationDto {
    private String officeName;
    private Long idTrip; // Trip
    private String officePhone;
    private String officePlace;
    private long officePrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate endContractDeadline; // VD: 31-12-1998
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startContractDeadline;

}
