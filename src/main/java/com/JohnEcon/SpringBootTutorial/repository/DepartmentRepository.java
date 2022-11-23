package com.JohnEcon.SpringBootTutorial.repository;

import com.JohnEcon.SpringBootTutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    /*
     * Here we define our own custom method-queries
     * We can define our own methods that correspond to a query with 2 ways
     *
     * 1. First way is by using some special keywords in the method name like
     * distinct,by{entityField},between,and
     *
     * 2. Second ways is by annotating the method with the SQL query we want to execute
     */

    public List<Department> findByDepartmentName(String departmentName);

    public List<Department> findByDepartmentNameStartingWithIgnoreCase(String departmentName);
}
