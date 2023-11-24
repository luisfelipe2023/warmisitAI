package com.proyecto.warmisitAI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.warmisitAI.models.BitacoraIncidentes;

@Repository
public interface BitacoraIncidentesRepository extends JpaRepository<BitacoraIncidentes , Integer> {

}
