package com.JohnEcon.SpringBootTutorial.service;

import com.JohnEcon.SpringBootTutorial.entity.Department;

import java.util.List;

public interface DepartmentService {

    public void saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentID);

    public void deleteDepartmentById(Long departmentID);

    public void updateDepartmentById(Long departmentID, Department department);

    public List<Department> retrieveDepartmentByName(String departmentName);

    public List<Department> retrieveDepartmentByNameFirstLetters(String departmentName);
}
