package com.ticket.ticket_ms.dto;

import com.ticket.ticket_ms.enums.TypeTicket;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketCreateDTO {
    private String codeTicket;
    private Float prixTicket;
    private TypeTicket typeTicket;
    private Long idEvenement;
    private Long idInternaut;
}
