package com.project.carparkv1.Dto.ParkinglotDto;

import lombok.Data;

@Data
public class ParkinglotCreationDto {
    private String parkName;
    private String parkPlace;
    private Long parkArea;
    private Long parkPrice;
}
