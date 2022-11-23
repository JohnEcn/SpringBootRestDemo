package com.JohnEcon.SpringBootTutorial.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class) // -> This annotation makes possible to mock api calls to test the endpoints
class DepartmentControllerTest {

    @BeforeEach
    void setUp() {
    }
}