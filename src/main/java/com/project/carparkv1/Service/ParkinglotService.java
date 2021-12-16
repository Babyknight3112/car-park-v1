package com.project.carparkv1.Service;

import com.project.carparkv1.Dao.ParkinglotDao;
import com.project.carparkv1.Dto.ParkinglotDto.ParkinglotCreationDto;
import com.project.carparkv1.Dto.ParkinglotDto.ParkinglotDto;
import com.project.carparkv1.Entity.Parkinglot;
import com.project.carparkv1.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkinglotService {

    private final ParkinglotDao parkinglotDao;
    private final Mapper mapper;

    @Autowired
    public ParkinglotService(ParkinglotDao parkinglotDao, Mapper mapper) {
        this.parkinglotDao = parkinglotDao;
        this.mapper = mapper;
    }

    public void addParkinglot(ParkinglotCreationDto parkinglotCreationDto) {
        Parkinglot parkinglot = mapper.toParkinglot(parkinglotCreationDto);
        parkinglotDao.save(parkinglot);
    }

    public ParkinglotDto getById(long id) {
        if (parkinglotDao.findById(id).isPresent()) {
            return mapper.toParkinglotDto(parkinglotDao.findById(id).get());
        }
        return null;
    }

    public List<ParkinglotDto> getAllParkinglot() {
        List<ParkinglotDto> parkinglotDtoList = new ArrayList<>();
        for (Parkinglot parkinglot : parkinglotDao.findAll()) {
            ParkinglotDto parkinglotDto = mapper.toParkinglotDto(parkinglot);
            parkinglotDtoList.add(parkinglotDto);
        }
        return parkinglotDtoList;
    }

    public List<ParkinglotDto> getById() {
        return getAllParkinglot();
    }

    public ParkinglotDto findByParkName(String parkName) {
        if (parkinglotDao.findByParkName(parkName).isPresent()) {
            return mapper.toParkinglotDto(parkinglotDao.findByParkName(parkName).get());
        }
        return null;
    }

    public ParkinglotDto findByParkPlace(String parkPlace) {
        return mapper.toParkinglotDto(parkinglotDao.findByParkPlace(parkPlace));
    }

    public List<ParkinglotDto> findByParkPrice(Long parkPrice) {
        List<ParkinglotDto> DB = new ArrayList<>();
        for (Parkinglot parkinglot : parkinglotDao.findByParkPrice(parkPrice)) {
            DB.add(mapper.toParkinglotDto(parkinglot));
        }
        return DB;
    }

}
