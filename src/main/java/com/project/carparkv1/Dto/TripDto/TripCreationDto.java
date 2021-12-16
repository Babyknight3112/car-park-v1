package com.project.carparkv1.Dto.TripDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TripCreationDto {
    private String destination;
    private LocalTime departureTime; // hh:mm:ss.ns
    private String driver;
    private String carType;
    private int maximumOnlineTicketNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate departureDate;
}
