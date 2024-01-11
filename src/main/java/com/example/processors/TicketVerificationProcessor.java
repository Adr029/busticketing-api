package com.example.processors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class TicketVerificationProcessor {

    private boolean isTicketValid;
    private String validatedTicket;

    public String getValidatedTicket() {
        return validatedTicket;
    }

    public void setValidatedTicket(String validatedTicket) {
        this.validatedTicket = validatedTicket;
    }

    public boolean isTicketValid() {
        return isTicketValid;
    }

    public void setTicketValid(boolean ticketValid) {

        isTicketValid = ticketValid;
    }
}
