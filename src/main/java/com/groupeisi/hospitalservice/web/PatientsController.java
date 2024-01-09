package com.groupeisi.hospitalservice.web;

import com.groupeisi.hospitalservice.entities.Patient;
import com.groupeisi.hospitalservice.services.IHospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {
    IHospitalService iHospitalService;
    public PatientsController(IHospitalService iHospitalService) {
        this.iHospitalService = iHospitalService;
    }

    @GetMapping()
    public List<Patient> getAll(){
        return iHospitalService.getAllPatient();
    }

    @GetMapping("{name}")
    public Patient getByName(@PathVariable("name") String name){
        return iHospitalService.findPatientByName(name);
    }

}
