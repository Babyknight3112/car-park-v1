package com.project.carparkv1.Dto.CarDto;

import lombok.Data;

@Data
public class CarCreationDto {
    private String licensePlate;
    private String carType;
    private String carColor;
    private String company;
    private Long idPark; // Parking lot
}
