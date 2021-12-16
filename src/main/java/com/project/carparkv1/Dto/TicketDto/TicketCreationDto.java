package com.project.carparkv1.Dto.TicketDto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TicketCreationDto {
    private String customerName;
    private LocalTime bookingTime; // VD: 12:12:12.00
    private Long tripId; // Trip
    private String plateLicense;
}
