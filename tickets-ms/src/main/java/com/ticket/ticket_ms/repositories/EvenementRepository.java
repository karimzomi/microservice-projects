package com.ticket.ticket_ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.ticket_ms.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
