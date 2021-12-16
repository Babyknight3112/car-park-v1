package com.project.carparkv1.Dao;

import com.project.carparkv1.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long > {
    
    Employee findByEmployeeName(String employeeName);

    Employee findByEmployeePhone(String employeePhone);

    Employee findByEmployeeEmail(String employeeEmail);
}
