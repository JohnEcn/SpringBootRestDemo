package com.JohnEcon.SpringBootTutorial.repository;

import com.JohnEcon.SpringBootTutorial.entity.Department;
import com.JohnEcon.SpringBootTutorial.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private DepartmentRepository deptRepo;

    @BeforeEach
    void setUp()
    {
        Department department = Department.builder()
                .departmentName("HR department")
                .departmentAddress("Athens,Greece")
                .departmentCode("ATH7717")
                .build();

        Employee employee = Employee.builder()
                        .employeeName("Johnny")
                        .employeeDepartment(department).
                        build();

        deptRepo.save(department);
        repository.save(employee);
    }

    @Nested
    class inner
    {
//        @Test
//        void testFindDeptNameByEmployeeName()
//        {
//            String deptName = repository.findByEmployeeNameDepartmentName("Johnny");
//            Assertions.assertEquals("HR department",deptName);
//        }
//        @Test
//        void testFindByEmployeeName()
//        {
//            Employee employee = repository.findByEmployeeName("Johnny");
//            Assertions.assertEquals("Johnny",employee.getEmployeeName());
//        }

    }

}