package com.groupeisi.hospitalservice.repositories;

import com.groupeisi.hospitalservice.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    List<Patient> findAll();
}
