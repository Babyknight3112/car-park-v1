package com.project.carparkv1.Controller;

import com.project.carparkv1.Dto.CarDto.CarCreationDto;
import com.project.carparkv1.Dto.CarDto.CarDto;
import com.project.carparkv1.Service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CM")
public class CarManagementController {

    private final CarService carService;

    public CarManagementController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public String addCar(@RequestBody CarCreationDto carCreationDto) {
        carService.addCar(carCreationDto);
        return "Successfully added a car!";
    }

    @GetMapping("/license_plate/{license_plate}")
    public Optional<CarDto> findCarByLicensePlate(@PathVariable("license_plate") String licensePlate) {
        return carService.getCarByLicensePlate(licensePlate);
    }

    @GetMapping("/license_plate/")
    public List<CarDto> findByLicensePlate() {
        return carService.findByLicensePlate();
    }

    @GetMapping()
    public List<CarDto> getAllCar() {
        return carService.getAllCar();
    }
}
