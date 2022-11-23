package com.JohnEcon.SpringBootTutorial.service;

import com.JohnEcon.SpringBootTutorial.entity.CompanyCar;

import java.util.List;

public interface CompanyCarService {

    public void insertCompanyCar(CompanyCar companyCar);

    public List<CompanyCar> fetchCompanyCars();
}
