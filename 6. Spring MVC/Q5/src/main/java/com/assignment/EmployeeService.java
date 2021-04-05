package com.assignment;

import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getListOfEmployees();
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(String employeeName);
    public Employee findEmployee(String employeeName);
}
