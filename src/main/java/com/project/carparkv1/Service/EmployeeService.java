package com.project.carparkv1.Service;

import com.project.carparkv1.Dao.EmployeeDao;
import com.project.carparkv1.Dto.EmployeeDto.EmployeeCreationDto;
import com.project.carparkv1.Dto.EmployeeDto.EmployeeDto;
import com.project.carparkv1.Entity.Employee;
import com.project.carparkv1.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    private final Mapper mapper;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao, Mapper mapper) {
        this.employeeDao = employeeDao;
        this.mapper = mapper;
    }

    public void addEmployee(EmployeeCreationDto employeeCreationDto) {
        Employee employee = mapper.toEmployee(employeeCreationDto);
        employeeDao.save(employee);
    }

    public Optional<EmployeeDto> getEmployeeById(long id) {
        if (employeeDao.findById(id).isPresent()) {
            Employee employee = employeeDao.findById(id).get();
            EmployeeDto employeeDto = mapper.toEmployeeDto(employee);
            return Optional.ofNullable(employeeDto);
        }
        return Optional.empty();
    }

    public List<EmployeeDto> getEmployeeByid() {
        return getAllEmployee();
    }

    public EmployeeDto getEmployeeByEmployeeName(String employeeName) {
        Employee employee = employeeDao.findByEmployeeName(employeeName);
        return mapper.toEmployeeDto(employee);
    }

    public EmployeeDto getEmployeeByEmployeeEmail(String employeeEmail) {
        Employee employee = employeeDao.findByEmployeeEmail(employeeEmail);
        return mapper.toEmployeeDto(employee);
    }

    public EmployeeDto getEmployeeByEmployeePhone(String employeePhone) {
        Employee employee = employeeDao.findByEmployeePhone(employeePhone);
        return mapper.toEmployeeDto(employee);

    }

    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeListOfAll = employeeDao.findAll();
        List<EmployeeDto> employeeDtoListOfAll = new ArrayList<>();
        for (Employee employee : employeeListOfAll) {
            EmployeeDto employeeDto = mapper.toEmployeeDto(employee);
            employeeDtoListOfAll.add(employeeDto);
        }
        return employeeDtoListOfAll;
    }

    public String updateEmployee(EmployeeCreationDto employeeCreationDto, long id) {
        if (employeeDao.findById(id).isPresent()) {
            Employee existedEmployee = employeeDao.findById(id).get();
            existedEmployee.setEmployeeEmail(employeeCreationDto.getEmployeeEmail());
            existedEmployee.setEmployeeAddress(employeeCreationDto.getEmployeeAddress());
            existedEmployee.setEmployeeName(employeeCreationDto.getEmployeeName());
            existedEmployee.setEmployeePhone(employeeCreationDto.getEmployeePhone());
            existedEmployee.setEmployeeBirthdate(employeeCreationDto.getEmployeeBirthdate());
            existedEmployee.setAccount(employeeCreationDto.getAccount());
            existedEmployee.setDepartment(employeeCreationDto.getDepartment());
            existedEmployee.setPassword(employeeCreationDto.getPassword());
            existedEmployee.setSex(employeeCreationDto.getSex());
            employeeDao.save(existedEmployee);
            return "successfully updated the employee have id = " + id;
        }
        return "Fail to update the employee have id = " + id;
    }

    public String deleteEmployeeById(long id) {
        employeeDao.deleteById(id);
        return "Successfully deleted the employee have id = " + id;
    }

}
