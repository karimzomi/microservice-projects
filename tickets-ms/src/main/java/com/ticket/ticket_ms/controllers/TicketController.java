package com.ticket.ticket_ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.ticket_ms.dto.TicketCreateDTO;
import com.ticket.ticket_ms.entities.Ticket;
import com.ticket.ticket_ms.enums.TypeTicket;
import com.ticket.ticket_ms.services.TicketService;

@RestController
@RequestMapping("")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/all")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    @GetMapping("/find")
    public Ticket findById(@RequestParam Long id) {
        return ticketService.findById(id);
    }

    @PostMapping("/save")
    public Ticket save(@RequestBody TicketCreateDTO ticketDTO) {
        return ticketService.save(ticketDTO);
    }

    @GetMapping("montantRecupereParEvtEtTypeTicket")
    public Double montantRecupereParEvtEtTypeTicket(@RequestParam String nomEvt, @RequestParam TypeTicket typeTicket) {
        return ticketService.montantRecupereParEvtEtTypeTicket(nomEvt, typeTicket);
    }

    @GetMapping("internauteLePlusActif")
    public String internauteLePlusActif() {
        return ticketService.internauteLePlusActif();
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        ticketService.deleteById(id);
    }
}