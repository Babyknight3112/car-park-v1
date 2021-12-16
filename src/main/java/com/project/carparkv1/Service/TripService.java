package com.project.carparkv1.Service;

import com.project.carparkv1.Dao.TripDao;
import com.project.carparkv1.Dto.TripDto.TripCreationDto;
import com.project.carparkv1.Dto.TripDto.TripDto;
import com.project.carparkv1.Entity.Trip;
import com.project.carparkv1.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripDao tripDao;
    private final Mapper mapper;

    @Autowired
    public TripService(TripDao tripDao, Mapper mapper) {
        this.tripDao = tripDao;
        this.mapper = mapper;
    }

    public void addTrip(TripCreationDto tripCreationDto) {
        tripDao.save(mapper.toTrip(tripCreationDto));
    }

    public Optional<TripDto> getTripById(long id) {
        if (tripDao.findById(id).isPresent()) {
            return Optional.ofNullable(mapper.toTripDto(tripDao.findById(id).get()));
        }
        return Optional.empty();
    }

    public List<TripDto> getTripById() {
        return getAllTrip();
    }

    public List<TripDto> getAllTrip() {
        List<TripDto> tripDtoList = new ArrayList<>();
        for (Trip trip : tripDao.findAll()) {
            tripDtoList.add(mapper.toTripDto(trip));
        }
        return tripDtoList;
    }

}
