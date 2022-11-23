package com.JohnEcon.SpringBootTutorial.service;

import com.JohnEcon.SpringBootTutorial.entity.Employee;
import com.JohnEcon.SpringBootTutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceIml implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public void insertEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployees() {
        return repository.findAll();
    }

    @Override
    public void updateEmployee(long id,Employee employee) {
        Employee emp = repository.findById(id).get();

        if(Objects.nonNull(employee.getEmployeeName()) &&
                !employee.getEmployeeName().equals(""))
        {
            emp.setEmployeeName(employee.getEmployeeName());
        }
        if(Objects.nonNull(employee.getEmployeeDepartment()))
        {
            emp.setEmployeeDepartment(employee.getEmployeeDepartment());
        }
        if(Objects.nonNull(employee.getCar()))
        {
            emp.setCar(employee.getCar());
        }

        repository.save(emp);
    }

    @Override
    public String fetchEmployeeDepartmentName(String name) {
        return repository.findByEmployeeNameDepartmentName(name);
    }

    @Override
    public void removeEmployeeAssignedCar(String name)
    {
        Employee emp = repository.findByEmployeeName(name);
        emp.setCar(null);
        repository.save(emp);
    }
}
