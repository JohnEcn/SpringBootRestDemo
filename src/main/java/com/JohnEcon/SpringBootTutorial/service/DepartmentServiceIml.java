package com.JohnEcon.SpringBootTutorial.service;

import com.JohnEcon.SpringBootTutorial.controller.error.ResourceDoesNotExistException;
import com.JohnEcon.SpringBootTutorial.entity.Department;
import com.JohnEcon.SpringBootTutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceIml implements DepartmentService{

    @Autowired
    private DepartmentRepository repository;

    @Override
    public void saveDepartment(Department department)
    {
        repository.save(department);// --> Save the Department entity directly to DB
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return repository.findAll(); // --> find all fetches all departments from DB (SELECT * FROM DEPARTMENTS)
    }

    @Override
    public Department fetchDepartmentById(Long departmentID) {

        Optional<Department> department = repository.findById(departmentID);
        if(!department.isPresent()){
            throw new ResourceDoesNotExistException("Resource not Found");
        }
        return repository.findById(departmentID).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentID) {
        repository.deleteById(departmentID);
    }

    @Override
    public void updateDepartmentById(Long departmentID, Department department)
    {
        //Getting the department obj from db
        Department dpt =  repository.findById(departmentID).get();

        //Update the dpt by checking the department object from the response body
        if(Objects.nonNull(department.getDepartmentAddress()) && !department.getDepartmentAddress().equalsIgnoreCase(""))
        {
            dpt.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().equalsIgnoreCase(""))
        {
            dpt.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !department.getDepartmentCode().equalsIgnoreCase(""))
        {
            dpt.setDepartmentCode(department.getDepartmentCode());
        }

        //Save the modified dpt object back to the db
        repository.save(dpt);
    }

    @Override
    public List<Department> retrieveDepartmentByName(String departmentName) {
        return repository.findByDepartmentName(departmentName);
    }

    @Override
    public List<Department> retrieveDepartmentByNameFirstLetters(String departmentName) {
        return repository.findByDepartmentNameStartingWithIgnoreCase(departmentName);
    }
}
