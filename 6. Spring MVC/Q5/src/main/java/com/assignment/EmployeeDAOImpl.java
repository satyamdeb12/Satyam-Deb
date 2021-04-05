package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    NamedParameterJdbcTemplate template;

    @Autowired
    public void setTemplate(NamedParameterJdbcTemplate template) throws DataAccessException {
        this.template = template;
    }

    private SqlParameterSource getSqlParamByModel(Employee employee){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(employee != null){
            parameterSource.addValue("employeeId",employee.getEmployeeId());
            parameterSource.addValue("employeeName", employee.getEmployeeName());
            parameterSource.addValue("employeeDepartment", employee.getEmployeeDepartment());
            parameterSource.addValue("employeeDesignation", employee.getEmployeeDesignation());
            parameterSource.addValue("employeeSalary", employee.getEmployeeSalary());
        }
        return parameterSource;
    }

    private static final class EmployeeMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("employeeId"));
            employee.setEmployeeName(resultSet.getString("employeeName"));
            employee.setEmployeeDepartment(resultSet.getString("employeeDepartment"));
            employee.setEmployeeDesignation(resultSet.getString("employeeDesignation"));
            employee.setEmployeeSalary(resultSet.getString("employeeSalary"));

            return employee;
        }
    }

    @Override
    public List<Employee> getListOfEmployees() {
        String query = "select * from employee";
        List<Employee> list = template.query(query,getSqlParamByModel(null),new EmployeeMapper());
        return list;
    }

    @Override
    public void addEmployee(Employee employee) {
        String query  = "insert into employee(employeeName, employeeDepartment, employeeDesignation, employeeSalary) values (:employeeName, :employeeDepartment, :employeeDesignation, :employeeSalary)";
        template.update(query,getSqlParamByModel(employee));
    }

    @Override
    public void updateEmployee(Employee employee) {
        String query = "update employee set employeeName = :employeeName, employeeDepartment = :employeeDepartment, employeeDesignation = :employeeDesignation, employeeSalary = :employeeSalary where employeeName = :employeeName";
        template.update(query,getSqlParamByModel(employee));
    }

    @Override
    public void deleteEmployee(String employeeName) {
        String query = "delete from employee where employeeName = :employeeName";
        template.update(query,getSqlParamByModel(new Employee(employeeName)));
    }

    @Override
    public Employee findEmployee(String employeeName) {
        String query = "select * from employee where employeeName = :employeeName";
        return (Employee) template.queryForObject(query, getSqlParamByModel(new Employee(employeeName)), new EmployeeMapper());
    }
}
