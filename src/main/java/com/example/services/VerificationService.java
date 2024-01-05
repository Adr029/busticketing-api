package com.example.services;

import com.example.exceptions.TicketInvalidException;
import com.example.model.ReservedTrip;
import com.example.processors.TicketVerificationProcessor;
import com.example.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public ReservedTrip checkReservation(String lastName, int ticketNumber) {
        reservation = reservationRepository.findReservation(ticketNumber, lastName);

        if (reservation == null) {
            throw new TicketInvalidException();
        }

        ticketVerificationProcessor.setValidatedTicket(ticketNumber);
        ticketVerificationProcessor.setTicketValid(true);
        return reservation;
    }


    public void rebookTrip(String date, String time, int ticketNumber, int newTrip) {

        reservationService.modifySeats(reservation.getTripId(), reservation.getQuantity(), true);
        reservationRepository.updateBooking(date, time, ticketNumber);
        reservationService.modifySeats(newTrip, reservation.getQuantity(), false);

            //TODO user may only rebook trip of same bus type
    }

    public void cancelTrip(int ticketNumber) {
        reservationService.modifySeats(reservation.getTripId(), reservation.getQuantity(), true);
        reservationRepository.cancelBooking(ticketNumber);
    }

    //! TEST METHOD
    public List<ReservedTrip> displayAllTestReserved() {
        return reservationRepository.getAllReservedTrips();
    }
}
