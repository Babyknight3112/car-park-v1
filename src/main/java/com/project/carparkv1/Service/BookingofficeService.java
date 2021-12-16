package com.project.carparkv1.Service;

import com.project.carparkv1.Dao.BookingofficeDao;
import com.project.carparkv1.Dto.BookingofficeDto.BookingofficeCreationDto;
import com.project.carparkv1.Dto.BookingofficeDto.BookingofficeDto;
import com.project.carparkv1.Entity.Bookingoffice;
import com.project.carparkv1.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingofficeService {

    private final BookingofficeDao bookingofficeDao;
    private final Mapper mapper;

    @Autowired
    public BookingofficeService(BookingofficeDao bookingofficeDao, Mapper mapper) {
        this.bookingofficeDao = bookingofficeDao;
        this.mapper = mapper;
    }

    public void addBookingoffice(BookingofficeCreationDto bookingofficeCreationDto) {
        Bookingoffice bookingoffice = mapper.toBookingoffice(bookingofficeCreationDto);
        bookingofficeDao.save(bookingoffice);
    }

    public Optional<Bookingoffice> getBookingofficeById(long id) {
        return bookingofficeDao.findById(id);
    }

    public BookingofficeDto findBookingofficeById(long id) {
        if (getBookingofficeById(id).isPresent()) {
            return mapper.toBookingofficeDto(getBookingofficeById(id).get());
        } else {
            System.out.println("No matches");
            return null;
        }
    }

    public List<BookingofficeDto> findBookingofficeById() {
        return getAllBookingoffice();
    }

    public List<BookingofficeDto> getAllBookingoffice() {
        List<BookingofficeDto> bookingofficeDtoList = new ArrayList<>();
        for (Bookingoffice bookingoffice : bookingofficeDao.findAll()) {
            BookingofficeDto bookingofficeDto = mapper.toBookingofficeDto(bookingoffice);
            bookingofficeDtoList.add(bookingofficeDto);
        }
        return bookingofficeDtoList;
    }

    public List<BookingofficeDto> findBookingofficeByOfficeName(String officeName) {
        List<BookingofficeDto> DB = new ArrayList<>();
        for (Bookingoffice bookingoffice : bookingofficeDao.findByOfficeName(officeName)) {
            DB.add(mapper.toBookingofficeDto(bookingoffice));
        }
        return DB;
    }

}
