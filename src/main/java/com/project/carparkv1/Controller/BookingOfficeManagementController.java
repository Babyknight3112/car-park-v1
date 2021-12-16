package com.project.carparkv1.Controller;

import com.project.carparkv1.Dto.BookingofficeDto.BookingofficeCreationDto;
import com.project.carparkv1.Dto.BookingofficeDto.BookingofficeDto;
import com.project.carparkv1.Service.BookingofficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BOM")
public class BookingOfficeManagementController {

    private final BookingofficeService bookingofficeService;

    public BookingOfficeManagementController(BookingofficeService bookingofficeService) {
        this.bookingofficeService = bookingofficeService;
    }

    @PostMapping("/add")
    public String addBookingOffice(@RequestBody BookingofficeCreationDto bookingofficeCreationDto) {
        bookingofficeService.addBookingoffice(bookingofficeCreationDto);
        return "Successfully added a booking office!";
    }

    @GetMapping("/id")
    public List<BookingofficeDto> findBookingOfficeById() {
        return bookingofficeService.findBookingofficeById();
    }

    @GetMapping("/id/{id}")
    public BookingofficeDto findBookingOfficeById(@PathVariable("id") long id) {
        return bookingofficeService.findBookingofficeById(id);
    }

    @GetMapping()
    public List<BookingofficeDto> getAllBookingOffice() {
        return bookingofficeService.getAllBookingoffice();
    }

    @GetMapping("/officeName/{officeName}")
    public List<BookingofficeDto> findBookingOfficeByOfficeName(@PathVariable("officeName") String officeName) {
        return bookingofficeService.findBookingofficeByOfficeName(officeName);
    }
}
