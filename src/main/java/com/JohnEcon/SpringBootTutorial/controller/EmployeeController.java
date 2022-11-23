package com.JohnEcon.SpringBootTutorial.controller;

import com.JohnEcon.SpringBootTutorial.entity.Department;
import com.JohnEcon.SpringBootTutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.JohnEcon.SpringBootTutorial.entity.Employee;

import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee")
    public void insertEmployee(@RequestBody Employee employee)
    {
       service.insertEmployee(employee);
    }

    @PostMapping("/employees")
    public void insertEmployees(@RequestBody List<Employee> employees)
    {
        Iterator<Employee> it = employees.iterator();

        while (it.hasNext())
        {
            service.insertEmployee(it.next());
        }
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployees()
    {
        return service.fetchEmployees();
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable("id") long id)
    {
            service.updateEmployee(id,employee);
    }

    @GetMapping("/employee/{name}/department")
    public String fetchEmployeeDepartmentName(@PathVariable("name") String name)
    {
        return service.fetchEmployeeDepartmentName(name);
    }

    @DeleteMapping("/employee/{name}/car")
    public void removeEmployeeAssignedCar(@PathVariable("name") String name)
    {
        service.removeEmployeeAssignedCar(name);
    }

}
