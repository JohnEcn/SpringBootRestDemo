package com.JohnEcon.SpringBootTutorial.repository;

import com.JohnEcon.SpringBootTutorial.entity.Department;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @BeforeEach
    void setUp()
    {
        Department department = Department.builder()
                        .departmentName("HR department")
                        .departmentAddress("Athens,Greece")
                        .departmentCode("ATH7717")
                        .build();

        repository.save(department);
    }
    @Nested
    class inner
    {

        @Test
        void findByNameTest()
        {
            List<Department> departments = repository.findByDepartmentName("HR department");
            assertEquals(departments.get(0).getDepartmentName(),"HR department");
        }

        @Test
        void findByNameStartingWithTest()
        {
            List<Department> department = repository.findByDepartmentNameStartingWithIgnoreCase("Hr");
            assertNotNull(department.get(0));
        }

        @Test
        void invalidDepartmentCodeTest()
        {
            Department department = Department.builder()
                    .departmentName("IT department")
                    .departmentAddress("Athens,Greece")
                    .departmentCode("ATH77172")
                    .build();

            assertThrows(ConstraintViolationException.class,()->repository.save(department));
        }

        @Test
        void invalidEmptyDepartmentNameTest()
        {
            Department department = Department.builder()
                    .departmentName("")
                    .departmentAddress("Athens,Greece")
                    .departmentCode("ATH77172")
                    .build();

            assertThrows(ConstraintViolationException.class,()->repository.save(department));
        }

        @Test
        void invalidNullDepartmentNameTest()
        {
            Department department = Department.builder()
                    .departmentAddress("Athens,Greece")
                    .departmentCode("ATH77172")
                    .build();

            assertThrows(ConstraintViolationException.class,()->repository.save(department));
        }
    }
}