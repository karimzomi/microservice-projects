package com.ticket.ticket_ms.entities;

import com.ticket.ticket_ms.enums.TypeTicket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private String codeTicket;
    private Float prixTicket;
    private TypeTicket typeTicket;

    @ManyToOne
    private Evenement evenement;

    @ManyToOne
    private Internaut internaut;

}
