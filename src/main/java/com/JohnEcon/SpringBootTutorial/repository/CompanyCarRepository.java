package com.JohnEcon.SpringBootTutorial.repository;

import com.JohnEcon.SpringBootTutorial.entity.CompanyCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyCarRepository extends JpaRepository<CompanyCar,Long> {
}
