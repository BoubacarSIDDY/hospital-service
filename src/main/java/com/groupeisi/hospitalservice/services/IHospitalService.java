package com.groupeisi.hospitalservice.services;

import com.groupeisi.hospitalservice.entities.Consultation;
import com.groupeisi.hospitalservice.entities.Medecin;
import com.groupeisi.hospitalservice.entities.Patient;
import com.groupeisi.hospitalservice.entities.RendezVous;

import java.util.List;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

    Patient findPatientByName(String name);
    List<Patient> getAllPatient();
    Medecin findMedecinByName(String name);
}
