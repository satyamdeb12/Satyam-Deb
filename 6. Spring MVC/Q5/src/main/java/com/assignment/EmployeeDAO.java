package com.assignment;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getListOfEmployees();
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(String employeeName);
    public Employee findEmployee(String employeeName);
}
