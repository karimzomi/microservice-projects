package com.ticket.ticket_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.ticket_ms.dto.TicketCreateDTO;
import com.ticket.ticket_ms.entities.Evenement;
import com.ticket.ticket_ms.entities.Internaut;
import com.ticket.ticket_ms.entities.Ticket;
import com.ticket.ticket_ms.enums.TypeTicket;
import com.ticket.ticket_ms.repositories.EvenementRepository;
import com.ticket.ticket_ms.repositories.InternautRepository;
import com.ticket.ticket_ms.repositories.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private InternautRepository internautRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket save(TicketCreateDTO ticket) {
        Evenement evenement = evenementRepository.findById(ticket.getIdEvenement()).orElse(null);
        Internaut internaut = internautRepository.findById(ticket.getIdInternaut()).orElse(null);
        if (evenement != null && internaut != null) {
            if (evenement.getNbPlaces() == 0) {
                throw new UnsupportedOperationException("Nombre de places demandées non disponible");
            }
            Ticket entity = Ticket.builder().codeTicket(ticket.getCodeTicket()).prixTicket(ticket.getPrixTicket())
                    .typeTicket(ticket.getTypeTicket()).evenement(evenement).internaut(internaut).build();
            evenement.setNbPlaces(evenement.getNbPlaces() - 1);
            evenementRepository.save(evenement);
            return ticketRepository.save(entity);
        }
        return null;
    }

    public Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket) {
        return ticketRepository.montantRecupereParEvtEtTypeTicket(nomEvt, typeTicket);
    }

    public String internauteLePlusActif() {
        return ticketRepository.internauteLePlusActif();
    }

    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    public Ticket update(Long id, Ticket ticket) {
        Ticket entity = ticketRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setCodeTicket(ticket.getCodeTicket());
            entity.setPrixTicket(ticket.getPrixTicket());
            entity.setTypeTicket(ticket.getTypeTicket());

            return ticketRepository.save(entity);
        }
        return null;
    }

}
