package com.JohnEcon.SpringBootTutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Value("${custom.config}")
    private String welcomeMsgFromConfig;

    @GetMapping("/")
    public String helloWorld()
    {
        return welcomeMsgFromConfig;
    }
}
