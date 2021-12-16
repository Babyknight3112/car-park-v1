package com.project.carparkv1.Dto.TripDto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TripDto {
    private long tripId;
    private String destination;
    private LocalTime departureTime; // 12:12:12.00
    private String driver;
    private String carType;
    private Integer bookedTicketNumber;
}
