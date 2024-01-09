package com.groupeisi.hospitalservice;

import com.groupeisi.hospitalservice.entities.*;
import com.groupeisi.hospitalservice.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(IHospitalService iHospitalService){
		return args -> {
			// save patient
			Stream.of("Aboubakr","Ousmane","Ali").forEach(name -> {
				Patient patient = new Patient();
				patient.setName(name);
				patient.setEmail(name+"@gmail.com");
				patient.setDateNaissance(new Date());
				iHospitalService.savePatient(patient);
			});
			// save a doctor
			Stream.of("Mr.Khamiss","Mr.Oky","Mme.Salima").forEach(name -> {
				Medecin medecin = new Medecin();
				medecin.setName(name);
				medecin.setEmail(name.toLowerCase()+"@gmail.com");
				medecin.setSpecialite(Math.random() > 0.5 ? "Infirmier" : "Dentiste");
				iHospitalService.saveMedecin(medecin);
			});

			// save an appointment
			Patient patient = iHospitalService.findPatientByName("Aboubakr");
			Medecin medecin = iHospitalService.findMedecinByName("Mr.Khamiss");
			RendezVous rendezVous = new RendezVous();
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			rendezVous.setStatutRDV(StatutRDV.PENDING);
			rendezVous.setDateRDV(new Date());
			iHospitalService.saveRDV(rendezVous);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRapport("Test rapport de consultation");
			consultation.setRendezVous(rendezVous);
			iHospitalService.saveConsultation(consultation);


			/**
			 * second method using Builder() to save a patient
				iHospitalService.savePatient(Patient.builder().name("Diallo").email("test@gmail.com").dateNaissance(new Date()).build());
			 **/
		};
	}

}
