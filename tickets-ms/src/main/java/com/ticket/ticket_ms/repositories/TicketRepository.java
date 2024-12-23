package com.ticket.ticket_ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticket.ticket_ms.entities.Ticket;
import com.ticket.ticket_ms.enums.TypeTicket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT SUM(t.prixTicket) FROM Ticket t WHERE t.evenement.nomEvenement = ?1 AND t.typeTicket = ?2")
    Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket);

    @Query("SELECT t.internaut.identifiant FROM Ticket t GROUP BY t.internaut.identifiant ORDER BY COUNT(t.internaut.identifiant) DESC LIMIT 1")
    String internauteLePlusActif();
}