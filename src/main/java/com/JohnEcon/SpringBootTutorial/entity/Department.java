package com.JohnEcon.SpringBootTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data //--> Lombok: This annotation adds at compile time the required Getters/setters/Constructor with args etc
@NoArgsConstructor //--> Lombok: This annotation adds at compile a default constructor
@AllArgsConstructor
@Builder
public class Department {

    @Id //--> Setting the departmentID as the primary key of table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //--> Setting the departmentID as auto generated id
    private long departmentID;

    @NotBlank(message = "Department Name required")
    private String departmentName;

    @NotBlank(message = "Department Address required")
    private String departmentAddress;

    @Length(max = 7,min = 7,message ="Department code has to be 7 characters long.")
    private String departmentCode;

}
