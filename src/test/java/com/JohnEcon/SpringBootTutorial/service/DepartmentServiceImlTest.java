package com.JohnEcon.SpringBootTutorial.service;

import com.JohnEcon.SpringBootTutorial.entity.Department;
import com.JohnEcon.SpringBootTutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImlTest {

    @Autowired
    private DepartmentServiceIml service;

    @MockBean
    private DepartmentRepository repository;

    @BeforeEach
    void setUp()
    {
    }

//    @Test
//    void getByDepartmentNameTest()
//    {
//        String deptName = "IT";
//        Department foundDept = service.retrieveDepartmentByName(deptName);
//        Assertions.assertEquals(deptName,foundDept.getDepartmentName());
//    }
//
//    @Test
//    void updateDepartmentNameByID()
//    {
//        String deptName = "IT";
//        Department foundDept = service.retrieveDepartmentByName(deptName);
//        Assertions.assertEquals(deptName,foundDept.getDepartmentName());
//    }
}