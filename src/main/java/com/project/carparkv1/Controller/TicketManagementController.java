package com.project.carparkv1.Controller;

import com.project.carparkv1.Dto.TicketDto.TicketCreationDto;
import com.project.carparkv1.Dto.TicketDto.TicketDto;
import com.project.carparkv1.Service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TKM")
public class TicketManagementController {

    private final TicketService ticketService;

    public TicketManagementController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/add")
    public String addTicket(@RequestBody TicketCreationDto ticketCreationDto) {
        ticketService.addTicket(ticketCreationDto);
        return "Successfully added a ticket!";
    }

    @GetMapping("/id/{id}")
    public Optional<TicketDto> findById(@PathVariable("id") long id) {
        return ticketService.findById(id);
    }

    @GetMapping("/id")
    public List<TicketDto> findById() {
        return ticketService.findById();
    }

    @GetMapping("/plateLicense/{plateLicense}")
    public List<TicketDto> findByPlateLicense(@PathVariable("plateLicense") String plateLicense) {
        return ticketService.findByPlateLicense(plateLicense);
    }

    @GetMapping("/customerName/{customerName}")
    public List<TicketDto> findByCustomerName(@PathVariable("customerName") String customerName) {
        return ticketService.findByCustomerName(customerName);
    }

    @GetMapping()
    public List<TicketDto> getAllTicket() {
        return ticketService.getAllTicket();
    }

    @DeleteMapping("/delete/{id}")
    public int deleteTicketById(@PathVariable("id") long id) {
        return ticketService.deleteTicketById(id);
    }
}
