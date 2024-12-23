package com.ticket.ticket_ms.services;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TicketAOPService {

    @Pointcut("execution(* com.ticket.ticket_ms.services.TicketService.save(..))")
    public void saveTicket() {
    }

    @AfterThrowing(pointcut = "saveTicket()", throwing = "ex")
    public void afterThrowingSaveTicket(UnsupportedOperationException ex) {
        System.out.println("Le nombre de places restantes dépasse le nombre de tickets demandés");
    }

}
