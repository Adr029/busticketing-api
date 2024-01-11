package com.example.services;

import com.example.exceptions.TicketInvalidException;
import com.example.model.ReservedTrip;
import com.example.processors.TicketVerificationProcessor;
import com.example.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerificationService {
    private final ReservationRepository reservationRepository;
    private final TicketVerificationProcessor ticketVerificationProcessor;
    private final ReservationService reservationService;

    private ReservedTrip reservation;

    public VerificationService(ReservationRepository reservationRepository, TicketVerificationProcessor ticketVerificationProcessor, ReservationService reservationService) {
        this.reservationRepository = reservationRepository;
        this.ticketVerificationProcessor = ticketVerificationProcessor;
        this.reservationService = reservationService;
    }

    public ReservedTrip checkReservation(String lastName, String ticketNumber) {
        reservation = reservationRepository.findReservation(ticketNumber, lastName);

        if (reservation == null) {
            throw new TicketInvalidException();
        }

        ticketVerificationProcessor.setValidatedTicket(ticketNumber);
        ticketVerificationProcessor.setTicketValid(true);
        return reservation;
    }


    public void rebookTrip(String date, String time, String ticketNumber, int newTrip) {

        reservationService.modifySeats(reservation.getTripId(), reservation.getQuantity(), true);
        reservationRepository.updateBooking(date, time, ticketNumber, newTrip);
        reservationService.modifySeats(newTrip, reservation.getQuantity(), false);

    }

    public void cancelTrip(String ticketNumber) {
        reservationService.modifySeats(reservation.getTripId(), reservation.getQuantity(), true);
        reservationRepository.cancelBooking(ticketNumber);
    }


}
