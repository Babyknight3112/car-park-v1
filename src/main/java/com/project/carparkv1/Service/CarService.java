package com.project.carparkv1.Service;

import com.project.carparkv1.Dao.CarDao;
import com.project.carparkv1.Dto.CarDto.CarCreationDto;
import com.project.carparkv1.Dto.CarDto.CarDto;
import com.project.carparkv1.Entity.Car;
import com.project.carparkv1.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarDao carDao;
    private final Mapper mapper;

    @Autowired
    public CarService(CarDao carDao, Mapper mapper) {
        this.carDao = carDao;
        this.mapper = mapper;
    }

    public void addCar(CarCreationDto carCreationDto){
        Car car = mapper.toCar(carCreationDto);
        carDao.save(car);
    }

    public Optional<CarDto> getCarByLicensePlate(String licensePlate){
        if (carDao.findById(licensePlate).isPresent()) {
            return Optional.ofNullable(mapper.toCarDto(carDao.findById(licensePlate).get()));
        }
        return Optional.empty();
    }

    public List<CarDto> getAllCar(){
        List<CarDto> carDtoList = new ArrayList<>();
        for(Car car : carDao.findAll()){
            carDtoList.add(mapper.toCarDto(car));
        }
        return carDtoList;
    }

    public List<CarDto> findByLicensePlate(){
        return getAllCar();
    }



}
