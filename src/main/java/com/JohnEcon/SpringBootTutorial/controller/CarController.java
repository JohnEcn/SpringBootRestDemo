package com.JohnEcon.SpringBootTutorial.controller;

import com.JohnEcon.SpringBootTutorial.entity.CompanyCar;
import com.JohnEcon.SpringBootTutorial.service.CompanyCarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CompanyCarServiceImp service;

    @PostMapping("/car")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insertCompanyCar(@RequestBody CompanyCar car)
    {
        service.insertCompanyCar(car);
    }

    @PostMapping("/cars")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insertCompanyCars(@RequestBody List<CompanyCar> cars)
    {
        Iterator<CompanyCar> it = cars.iterator();

        while(it.hasNext())
        {
            service.insertCompanyCar(it.next());
        }
    }

    @GetMapping("/cars")
    public List<CompanyCar> fetchCompanyCars()
    {
        return service.fetchCompanyCars();
    }
}
