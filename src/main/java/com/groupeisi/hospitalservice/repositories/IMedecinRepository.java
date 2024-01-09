package com.groupeisi.hospitalservice.repositories;

import com.groupeisi.hospitalservice.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByName(String name);
}
