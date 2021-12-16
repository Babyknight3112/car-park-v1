package com.project.carparkv1.Controller;

import com.project.carparkv1.Dto.EmployeeDto.EmployeeCreationDto;
import com.project.carparkv1.Dto.EmployeeDto.EmployeeDto;
import com.project.carparkv1.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/HRM")
public class HumanResourceManagementController {

    private final EmployeeService employeeService;

    public HumanResourceManagementController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeCreationDto employeeCreationDto) {
        employeeService.addEmployee(employeeCreationDto);
        return "Successfully Added an employee!";
    }

    @GetMapping(path = "/id/{id}")
    public Optional<EmployeeDto> getEmployeeById(@PathVariable("id") long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/id")
    public List<EmployeeDto> getEmployeeById() {
        return employeeService.getEmployeeByid();
    }

    @GetMapping(path = "/name/{name}")
    public EmployeeDto getEmployeeByEmployeeName(@PathVariable("name") String employeeName) {
        return employeeService.getEmployeeByEmployeeName(employeeName);
    }

    @GetMapping(path = "/email/{email}")
    public EmployeeDto getEmployeeByEmployeeEmail(@PathVariable("email") String employeeEmail) {
        return employeeService.getEmployeeByEmployeeEmail(employeeEmail);
    }

    @GetMapping(path = "/phone/{phone}")
    public EmployeeDto getEmployeeByEmployeePhone(@PathVariable("phone") String employeePhone) {
        return employeeService.getEmployeeByEmployeePhone(employeePhone);
    }

    @GetMapping()
    public List<EmployeeDto> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PutMapping(path = "/{id_update}")
    public String updateEmployee(@RequestBody EmployeeCreationDto employeeCreationDto, @PathVariable("id_update") long id) {
        return employeeService.updateEmployee(employeeCreationDto, id);
    }

    @DeleteMapping(path = "/{id_delete}")
    public String deleteEmployeeById(@PathVariable("id_delete") long id) {
        return employeeService.deleteEmployeeById(id);
    }
}
