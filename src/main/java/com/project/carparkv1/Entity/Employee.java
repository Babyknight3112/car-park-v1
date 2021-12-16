package com.project.carparkv1.Entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employeeId")
    private long employeeId;
    @Basic
    @Column(name = "account", length = 50, nullable = false)
    private String account;
    @Basic
    @Column(name = "department", length = 10, nullable = false)
    private String department;
    @Basic
    @Column(name = "employeeAddress", length = 50)
    private String employeeAddress;
    @Basic
    @Column(name = "employeeBirthdate")
    private LocalDate employeeBirthdate;
    @Basic
    @Column(name = "employeeEmail", length = 50)
    private String employeeEmail;
    @Basic
    @Column(name = "employeeName", length = 50, nullable = false)
    private String employeeName;
    @Basic
    @Column(name = "employeePhone", length = 10, nullable = false)
    private String employeePhone;
    @Basic
    @Column(name = "password", length = 20, nullable = false)
    private String password;
    @Basic
    @Column(name = "sex", length = 10, nullable = false)
    private String sex;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public LocalDate getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public void setEmployeeBirthdate(LocalDate employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Objects.equals(account, employee.account) && Objects.equals(department, employee.department) && Objects.equals(employeeAddress, employee.employeeAddress) && Objects.equals(employeeBirthdate, employee.employeeBirthdate) && Objects.equals(employeeEmail, employee.employeeEmail) && Objects.equals(employeeName, employee.employeeName) && Objects.equals(employeePhone, employee.employeePhone) && Objects.equals(password, employee.password) && Objects.equals(sex, employee.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, account, department, employeeAddress, employeeBirthdate, employeeEmail, employeeName, employeePhone, password, sex);
    }
}
