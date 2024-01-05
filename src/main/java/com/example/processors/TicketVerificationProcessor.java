package com.example.processors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class TicketVerificationProcessor {

    private boolean isTicketValid;


    //TODO modify ticket number of other classes to utilize String
    private int validatedTicket;

    public int getValidatedTicket() {
        return validatedTicket;
    }

    public void setValidatedTicket(int validatedTicket) {
        this.validatedTicket = validatedTicket;
    }

    public boolean isTicketValid() {
        return isTicketValid;
    }
    public void setTicketValid(boolean ticketValid) {

        isTicketValid = ticketValid;
    }
}
