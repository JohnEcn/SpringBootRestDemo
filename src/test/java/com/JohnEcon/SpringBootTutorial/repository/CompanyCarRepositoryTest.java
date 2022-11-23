package com.JohnEcon.SpringBootTutorial.repository;

import com.JohnEcon.SpringBootTutorial.entity.CompanyCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyCarRepositoryTest {

    @Autowired
    private CompanyCarRepository repository;

    @Test
    void invalidBlankRegistrationTest()
    {
        CompanyCar car = CompanyCar.builder()
                .manufacturer("Toyota")
                .model("Yaris GR")
                .registrationPlate("")
                .build();

        assertThrows(ConstraintViolationException.class,()->repository.save(car));
    }

    @Test
    void invalidLengthRegistrationTest()
    {
        CompanyCar car = CompanyCar.builder()
                .manufacturer("Toyota")
                .model("Yaris GR")
                .registrationPlate("BOT23122")
                .build();

        assertThrows(ConstraintViolationException.class,()->repository.save(car));
    }
}