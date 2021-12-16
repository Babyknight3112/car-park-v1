package com.project.carparkv1.Controller;

import com.project.carparkv1.Dto.ParkinglotDto.ParkinglotCreationDto;
import com.project.carparkv1.Dto.ParkinglotDto.ParkinglotDto;
import com.project.carparkv1.Service.ParkinglotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/PLM")
public class ParkingLotManagementController {

    private final ParkinglotService parkinglotService;

    public ParkingLotManagementController(ParkinglotService parkinglotService) {
        this.parkinglotService = parkinglotService;
    }

    @PostMapping("/add")
    public String addParkingLot(@RequestBody ParkinglotCreationDto parkinglotCreationDto) {
        parkinglotService.addParkinglot(parkinglotCreationDto);
        return "Successfully added a parking lot!";
    }

    @GetMapping("/id/{id}")
    public ParkinglotDto getById(@PathVariable("id") long id) {
        return parkinglotService.getById(id);
    }

    @GetMapping("/id")
    public List<ParkinglotDto> getById() {
        return parkinglotService.getById();
    }

    @GetMapping()
    public List<ParkinglotDto> getAllParkingLot() {
        return parkinglotService.getAllParkinglot();
    }

    @GetMapping("/name/{name}")
    public ParkinglotDto findByParkName(@PathVariable("name") String parkName) {
        return parkinglotService.findByParkName(parkName);
    }

    @GetMapping("/place/{place}")
    public ParkinglotDto findByParkPlace(@PathVariable("place") String parkPlace) {
        return parkinglotService.findByParkPlace(parkPlace);
    }

    @GetMapping("/price/{price}")
    public List<ParkinglotDto> findByParkPrice(@PathVariable("price") Long parkPrice) {
        return parkinglotService.findByParkPrice(parkPrice);
    }
}
