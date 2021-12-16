package com.project.carparkv1.Dto.EmployeeDto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class EmployeeDto {
    private long employeeId;
    private String employeeName;
    private LocalDate employeeBirthdate; // VD: 31-12-1998
    private String employeeAddress;
    private String employeePhone;
    private String department;
}
