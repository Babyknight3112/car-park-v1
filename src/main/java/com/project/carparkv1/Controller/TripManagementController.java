package com.project.carparkv1.Controller;

import com.project.carparkv1.Dto.TripDto.TripCreationDto;
import com.project.carparkv1.Dto.TripDto.TripDto;
import com.project.carparkv1.Service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TM")
public class TripManagementController {

    private final TripService tripService;

    public TripManagementController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/add")
    public String addTrip(@RequestBody TripCreationDto tripCreationDto) {
        tripService.addTrip(tripCreationDto);
        return "Successfully added a trip!";
    }

    @GetMapping("/id/{id}")
    public Optional<TripDto> getTripById(@PathVariable("id") long id) {
        return tripService.getTripById(id);
    }

    @GetMapping("/id")
    public List<TripDto> getTripById() {
        return tripService.getTripById();
    }

    @GetMapping()
    public List<TripDto> getAllTrip() {
        return tripService.getAllTrip();
    }
}
