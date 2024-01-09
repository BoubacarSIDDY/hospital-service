package com.groupeisi.hospitalservice.repositories;

import com.groupeisi.hospitalservice.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultationRepository extends JpaRepository<Consultation, Long> {
}
