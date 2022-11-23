package com.JohnEcon.SpringBootTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data //--> Lombok: This annotation adds at compile time the required Getters/setters/Constructor with args etc
@NoArgsConstructor //--> Lombok: This annotation adds at compile a default constructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    private String employeeName;

    @ManyToOne(targetEntity = Department.class,cascade = CascadeType.DETACH)
    @JoinColumn(name = "departmentID",referencedColumnName = "departmentID")
    private Department employeeDepartment;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinTable(name = "EMPLOYEE_COMPANY_CAR",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "carID"))
    private CompanyCar car;

}

