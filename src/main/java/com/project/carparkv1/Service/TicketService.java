package com.project.carparkv1.Service;

import com.project.carparkv1.Dao.TicketDao;
import com.project.carparkv1.Dto.TicketDto.TicketCreationDto;
import com.project.carparkv1.Dto.TicketDto.TicketDto;
import com.project.carparkv1.Entity.Ticket;
import com.project.carparkv1.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketDao ticketDao;
    private final Mapper mapper;

    @Autowired
    public TicketService(TicketDao ticketDao, Mapper mapper) {
        this.ticketDao = ticketDao;
        this.mapper = mapper;
    }

    public void addTicket(TicketCreationDto ticketCreationDto) {
        ticketDao.save(mapper.toTicket(ticketCreationDto));
    }

    public Optional<TicketDto> findById(long id) {
        if (ticketDao.findById(id).isPresent()) {
            return Optional.ofNullable(mapper.toTicketDto(ticketDao.findById(id).get()));
        }
        return Optional.empty();
    }

    public List<TicketDto> findById() {
        return getAllTicket();
    }

    public List<TicketDto> findByPlateLicense(String plateLicense) {
        List<TicketDto> DB = new ArrayList<>();
        for (Ticket ticket : ticketDao.findByPlateLicense(plateLicense)) {
            DB.add(mapper.toTicketDto(ticket));
        }
        return DB;
    }

    public List<TicketDto> findByCustomerName(String customerName) {
        List<TicketDto> GG = new ArrayList<>();
        for (Ticket ticket : ticketDao.findByCustomerName(customerName)) {
            GG.add(mapper.toTicketDto(ticket));
        }
        return GG;
    }

    public List<TicketDto> getAllTicket() {
        List<TicketDto> ticketDtoList = new ArrayList<>();
        for (Ticket ticket : ticketDao.findAll()) {
            ticketDtoList.add(mapper.toTicketDto(ticket));
        }
        return ticketDtoList;
    }

    public int deleteTicketById(long id) {
        if (ticketDao.findById(id).isPresent()) {
            ticketDao.delete(ticketDao.findById(id).get());
            return 1;
        }
        return 0;
    }
}
