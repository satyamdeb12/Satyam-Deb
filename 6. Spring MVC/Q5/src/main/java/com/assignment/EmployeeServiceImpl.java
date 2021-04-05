package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getListOfEmployees() {
        return employeeDAO.getListOfEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(String employeeName) {
        employeeDAO.deleteEmployee(employeeName);
    }

    @Override
    public Employee findEmployee(String employeeName) {
        return employeeDAO.findEmployee(employeeName);
    }
}
