package com.JohnEcon.SpringBootTutorial.repository;

import com.JohnEcon.SpringBootTutorial.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(
            value = "SELECT DEPARTMENT_NAME FROM DEPARTMENT D JOIN EMPLOYEE E " +
                    "ON  D.DEPARTMENTID=E.DEPARTMENTID " +
                    "WHERE E.EMPLOYEE_NAME = ?1",
            nativeQuery = true)
    public String findByEmployeeNameDepartmentName(String name);

    public Employee findByEmployeeName(String name);
}
