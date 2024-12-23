package com.evenement.evenement_ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evenement.evenement_ms.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}