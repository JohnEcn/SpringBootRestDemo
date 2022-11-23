package com.JohnEcon.SpringBootTutorial.service;

import com.JohnEcon.SpringBootTutorial.entity.CompanyCar;
import com.JohnEcon.SpringBootTutorial.repository.CompanyCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyCarServiceImp {

    @Autowired
    private CompanyCarRepository repository;

    public void insertCompanyCar(CompanyCar companyCar)
    {
        repository.save(companyCar);
    }

    public List<CompanyCar> fetchCompanyCars()
    {
        return repository.findAll();
    }
}
