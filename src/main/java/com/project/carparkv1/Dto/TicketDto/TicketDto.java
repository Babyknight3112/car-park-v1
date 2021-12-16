package com.project.carparkv1.Dto.TicketDto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TicketDto {
    private long ticketId;
    private String destination; // Trip
    private String plateLicense;
    private String customerName;
    private LocalTime bookingTime;
}
