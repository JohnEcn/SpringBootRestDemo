package com.JohnEcon.SpringBootTutorial.service;

import com.JohnEcon.SpringBootTutorial.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void insertEmployee(Employee employee);

    public String fetchEmployeeDepartmentName(String name);

    public void removeEmployeeAssignedCar(String name);

    public void updateEmployee(long id,Employee employee);

    public List<Employee> fetchEmployees();
}
