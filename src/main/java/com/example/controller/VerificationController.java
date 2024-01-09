package com.example.controller;

import com.example.exceptions.UnathorizedOperationException;
import com.example.model.ReservedTrip;
import com.example.processors.TicketVerificationProcessor;
import com.example.services.ReservationService;
import com.example.services.ResponseMessageService;
import com.example.services.VerificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VerificationController {

    private final VerificationService verificationService;
    private final ReservationService reservationService;
    private final TicketVerificationProcessor ticketVerificationProcessor;

    private final ResponseMessageService responseMessageService;


    public VerificationController(VerificationService verificationService, ReservationService reservationService, TicketVerificationProcessor ticketVerificationProcessor, ResponseMessageService responseMessageService) {
        this.verificationService = verificationService;
        this.reservationService = reservationService;
        this.ticketVerificationProcessor = ticketVerificationProcessor;
        this.responseMessageService = responseMessageService;
    }



    @GetMapping("/verify/{ticketnumber}")
    public ReservedTrip verifyTrip(
            @PathVariable("ticketnumber") int ticketNumber,
            @RequestParam String lastName
    )
    {
        return verificationService.checkReservation(lastName, ticketNumber);
    }

    @PatchMapping("/verify/{ticketnumber}/rebook")
    public ResponseEntity<?> rebookTrip(
            @PathVariable("ticketnumber") int ticketNumber,
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam int newTrip
    )
    {

        validateCredentials(ticketNumber);
        verificationService.rebookTrip(date, time, ticketNumber, newTrip);
        return responseMessageService.createMessage("Trip rebooked.", HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/verify/{ticketnumber}/cancel")
    public ResponseEntity<?> cancelTrip(
            @PathVariable("ticketnumber") int ticketNumber
    )
    {
        validateCredentials(ticketNumber);

        verificationService.cancelTrip(ticketNumber);
        return responseMessageService.createMessage("Trip canceled.", HttpStatus.ACCEPTED);
    }

    private void validateCredentials(int ticketNumber)
    {
        if (!ticketVerificationProcessor.isTicketValid() || ticketVerificationProcessor.getValidatedTicket() != ticketNumber) {
            throw new UnathorizedOperationException();
        }
    }


}
