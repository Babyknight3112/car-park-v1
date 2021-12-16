package com.project.carparkv1.Mapper;

import com.project.carparkv1.Dao.ParkinglotDao;
import com.project.carparkv1.Dao.TripDao;
import com.project.carparkv1.Dto.BookingofficeDto.BookingofficeCreationDto;
import com.project.carparkv1.Dto.BookingofficeDto.BookingofficeDto;
import com.project.carparkv1.Dto.CarDto.CarCreationDto;
import com.project.carparkv1.Dto.CarDto.CarDto;
import com.project.carparkv1.Dto.EmployeeDto.EmployeeCreationDto;
import com.project.carparkv1.Dto.EmployeeDto.EmployeeDto;
import com.project.carparkv1.Dto.ParkinglotDto.ParkinglotCreationDto;
import com.project.carparkv1.Dto.ParkinglotDto.ParkinglotDto;
import com.project.carparkv1.Dto.TicketDto.TicketCreationDto;
import com.project.carparkv1.Dto.TicketDto.TicketDto;
import com.project.carparkv1.Dto.TripDto.TripCreationDto;
import com.project.carparkv1.Dto.TripDto.TripDto;
import com.project.carparkv1.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private final TripDao tripDao;
    private final ParkinglotDao parkinglotDao;

    @Autowired
    public Mapper(TripDao tripDao, ParkinglotDao parkinglotDao) {
        this.tripDao = tripDao;
        this.parkinglotDao = parkinglotDao;
    }

    public EmployeeDto toEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName(employee.getEmployeeName());
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmployeeBirthdate(employee.getEmployeeBirthdate());
        employeeDto.setEmployeeAddress(employee.getEmployeeAddress());
        employeeDto.setEmployeePhone(employee.getEmployeePhone());
        employeeDto.setDepartment(employee.getDepartment());
        return employeeDto;
    }

    public Employee toEmployee(EmployeeCreationDto employeeCreationDto){
        Employee employee = new Employee();
        employee.setAccount(employeeCreationDto.getAccount());
        employee.setDepartment(employeeCreationDto.getDepartment());
        employee.setEmployeeAddress(employeeCreationDto.getEmployeeAddress());
        employee.setEmployeeBirthdate(employeeCreationDto.getEmployeeBirthdate());
        employee.setEmployeeEmail(employeeCreationDto.getEmployeeEmail());
        employee.setEmployeeName(employeeCreationDto.getEmployeeName());
        employee.setEmployeePhone(employeeCreationDto.getEmployeePhone());
        employee.setPassword(employeeCreationDto.getPassword());
        employee.setSex(employeeCreationDto.getSex());
        return employee;
    }

    public BookingofficeDto toBookingofficeDto(Bookingoffice bookingoffice){
        BookingofficeDto bookingofficeDto = new BookingofficeDto();
        bookingofficeDto.setOfficeId(bookingoffice.getOfficeId());
        bookingofficeDto.setOfficeName(bookingoffice.getOfficeName());
        bookingofficeDto.setDestination(tripDao.getById(bookingoffice.getIdTrip()).getDestination());
        return bookingofficeDto;
    }

    public Bookingoffice toBookingoffice(BookingofficeCreationDto bookingofficeCreationDto){
        Bookingoffice bookingoffice = new Bookingoffice();
        bookingoffice.setOfficeName(bookingofficeCreationDto.getOfficeName());
        bookingoffice.setOfficePhone(bookingofficeCreationDto.getOfficePhone());
        bookingoffice.setOfficePlace(bookingofficeCreationDto.getOfficePlace());
        bookingoffice.setOfficePrice(bookingofficeCreationDto.getOfficePrice());
        bookingoffice.setStartContractDeadline(bookingofficeCreationDto.getStartContractDeadline());
        bookingoffice.setEndContractDeadline(bookingofficeCreationDto.getEndContractDeadline());
        bookingoffice.setIdTrip(bookingofficeCreationDto.getIdTrip());
        return bookingoffice;
    }

    public ParkinglotDto toParkinglotDto(Parkinglot parkinglot){
        ParkinglotDto parkinglotDto = new ParkinglotDto();
        parkinglotDto.setParkId(parkinglot.getParkId());
        parkinglotDto.setParkName(parkinglot.getParkName());
        parkinglotDto.setParkPlace(parkinglot.getParkPlace());
        parkinglotDto.setParkPrice(parkinglot.getParkPrice());
        parkinglotDto.setParkStatus(parkinglot.getParkStatus());
        return parkinglotDto;
    }

    public Parkinglot toParkinglot(ParkinglotCreationDto parkinglotCreationDto){
        Parkinglot parkinglot = new Parkinglot();
        parkinglot.setParkName(parkinglotCreationDto.getParkName());
        parkinglot.setParkPlace(parkinglotCreationDto.getParkPlace());
        parkinglot.setParkArea(parkinglotCreationDto.getParkArea());
        parkinglot.setParkPrice(parkinglotCreationDto.getParkPrice());
        return parkinglot;
    }

    public Car toCar(CarCreationDto carCreationDto){
        Car car = new Car();
        car.setLicensePlate(carCreationDto.getLicensePlate());
        car.setCarType(carCreationDto.getCarType());
        car.setCarColor(carCreationDto.getCarColor());
        car.setCompany(carCreationDto.getCompany());
        car.setIdPark(carCreationDto.getIdPark());
        return car;
    }

    public CarDto toCarDto(Car car){
        CarDto carDto = new CarDto();
        carDto.setLicensePlate(car.getLicensePlate());
        carDto.setCarType(car.getCarType());
        carDto.setCarColor(car.getCarColor());
        carDto.setCompany(car.getCompany());
        carDto.setParkName(parkinglotDao.getById(car.getIdPark()).getParkName());
        return carDto;
    }

    public Trip toTrip(TripCreationDto tripCreationDto){
        Trip trip = new Trip();
        trip.setDestination(tripCreationDto.getDestination());
        trip.setDepartureTime(tripCreationDto.getDepartureTime());
        trip.setDriver(tripCreationDto.getDriver());
        trip.setCarType(tripCreationDto.getCarType());
        trip.setMaximumOnlineTicketNumber(tripCreationDto.getMaximumOnlineTicketNumber());
        trip.setDepartureDate(tripCreationDto.getDepartureDate());
        return trip;
    }

    public TripDto toTripDto(Trip trip){
        TripDto tripDto = new TripDto();
        tripDto.setTripId(trip.getTripId());
        tripDto.setDestination(trip.getDestination());
        tripDto.setDepartureTime(trip.getDepartureTime());
        tripDto.setDriver(trip.getDriver());
        tripDto.setCarType(trip.getCarType());
        tripDto.setBookedTicketNumber(trip.getBookedTicketNumber());
        return tripDto;
    }

    public Ticket toTicket(TicketCreationDto ticketCreationDto){
        Ticket ticket = new Ticket();
        ticket.setCustomerName(ticketCreationDto.getCustomerName());
        ticket.setBookingTime(ticketCreationDto.getBookingTime());
        ticket.setTripId(ticketCreationDto.getTripId());
        ticket.setPlateLicense(ticketCreationDto.getPlateLicense());
        return ticket;
    }

    public TicketDto toTicketDto(Ticket ticket){
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicketId(ticket.getTicketId());
        ticketDto.setDestination(tripDao.getById(ticket.getTripId()).getDestination());
        ticketDto.setPlateLicense(ticket.getPlateLicense());
        ticketDto.setCustomerName(ticket.getCustomerName());
        ticketDto.setBookingTime(ticket.getBookingTime());
        return ticketDto;
    }

}
