package com.project.carparkv1.Dto.EmployeeDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeCreationDto {
    private String account;
    private String department;
    private String employeeAddress;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate employeeBirthdate; // VD: 31-12-1998
    private String employeeEmail;
    private String employeeName;
    private String employeePhone;
    private String password;
    private String sex;
}
