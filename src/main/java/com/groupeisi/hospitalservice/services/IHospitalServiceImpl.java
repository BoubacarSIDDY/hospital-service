package com.groupeisi.hospitalservice.services;

import com.groupeisi.hospitalservice.entities.Consultation;
import com.groupeisi.hospitalservice.entities.Medecin;
import com.groupeisi.hospitalservice.entities.Patient;
import com.groupeisi.hospitalservice.entities.RendezVous;
import com.groupeisi.hospitalservice.repositories.IConsultationRepository;
import com.groupeisi.hospitalservice.repositories.IMedecinRepository;
import com.groupeisi.hospitalservice.repositories.IPatientRepository;
import com.groupeisi.hospitalservice.repositories.IRendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    IPatientRepository iPatientRepository;
    IMedecinRepository iMedecinRepository;
    IRendezVousRepository iRendezVousRepository;
    IConsultationRepository iConsultationRepository;

    public IHospitalServiceImpl(IPatientRepository iPatientRepository, IMedecinRepository iMedecinRepository, IRendezVousRepository iRendezVousRepository, IConsultationRepository iConsultationRepository) {
        this.iPatientRepository = iPatientRepository;
        this.iMedecinRepository = iMedecinRepository;
        this.iRendezVousRepository = iRendezVousRepository;
        this.iConsultationRepository = iConsultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return iPatientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return iMedecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return iRendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return iConsultationRepository.save(consultation);
    }

    @Override
    public Patient findPatientByName(String name) {
        return iPatientRepository.findByName(name);
    }

    @Override
    public List<Patient> getAllPatient() {
        return iPatientRepository.findAll();
    }

    @Override
    public Medecin findMedecinByName(String name) {
        return iMedecinRepository.findByName(name);
    }
}
