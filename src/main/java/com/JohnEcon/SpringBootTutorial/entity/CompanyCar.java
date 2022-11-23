package com.JohnEcon.SpringBootTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data //--> Lombok: This annotation adds at compile time the required Getters/setters/Constructor with args etc
@NoArgsConstructor //--> Lombok: This annotation adds at compile a default constructor
@AllArgsConstructor
@Builder
public class CompanyCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;

    @NotBlank(message = "Registration number cannot be empty")
    @Length(min = 7,max = 7,message = "Incorrect registration length")
    private String registrationPlate;
    private String model;
    private String manufacturer;
}
