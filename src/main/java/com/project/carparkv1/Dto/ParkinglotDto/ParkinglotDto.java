package com.project.carparkv1.Dto.ParkinglotDto;

import lombok.Data;

@Data
public class ParkinglotDto {
    private long parkId;
    private String parkName;
    private String parkPlace;
    private Long parkPrice;
    private String parkStatus;
}
