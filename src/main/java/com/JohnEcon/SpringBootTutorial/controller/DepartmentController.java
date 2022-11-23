package com.JohnEcon.SpringBootTutorial.controller;

import com.JohnEcon.SpringBootTutorial.entity.Department;
import com.JohnEcon.SpringBootTutorial.service.DepartmentServiceIml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired // --> Spring automatically injects the Object that exists in the IOC container
    private DepartmentServiceIml service;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveDepartment(@Valid @RequestBody Department department) //--> @RequestBody converts automatically the response body JSON to a Department Object
    {
        service.saveDepartment(department);
    }

    @PostMapping("/departments")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveDepartments(@RequestBody List<Department> departments) //--> @RequestBody converts automatically the response body JSON to a Department Object
    {
        Iterator<Department> it = departments.iterator();

        while(it.hasNext())
        {
            service.saveDepartment(it.next());
        }
    }

    @GetMapping("/departments")
    public List<Department> retrieveDepartments()
    {
        return service.fetchDepartmentList();
    }

    @GetMapping("/department/{id}")
    public Department retrieveDepartmentById(@PathVariable("id") Long departmentID) //--> @PathVariable passes the id from the url to the method parameter
    {
        return service.fetchDepartmentById(departmentID);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long departmentID)
    {
        service.deleteDepartmentById(departmentID);
    }

    @PutMapping("/department/{id}")
    public void updateDepartmentById(@PathVariable("id") Long departmentID,@RequestBody Department department)
    {
        service.updateDepartmentById(departmentID,department);
    }

    @GetMapping("/department/name/{name}")
    public List<Department> retrieveDepartmentByName(@PathVariable("name") String departmentName)
    {
        return service.retrieveDepartmentByName(departmentName);
    }

    @GetMapping("/department/name/like/{name}")
    public List<Department> retrieveDepartmentByNameFirstLetters(@PathVariable("name") String departmentName)
    {
        return service.retrieveDepartmentByNameFirstLetters(departmentName);
    }

    @GetMapping("/param")
    public String paramTest(@RequestParam String testValue,@RequestParam(required = false) String testValue2)
    {
        //Getting the query parameters from the url
        return testValue + " " + testValue2;
    }
}
