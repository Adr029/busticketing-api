package com.example.services;

import com.example.model.AvailableTrip;
import com.example.model.ReservedTrip;
import com.example.processors.FareCalculatorProcessor;
import com.example.processors.TicketNumberProcessor;
import com.example.repository.ReservationRepository;
import com.example.repository.TripRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TripRepository tripRepository;
    private final FareCalculatorProcessor fareCalculatorProcessor;

    private final TicketNumberProcessor ticketNumberProcessor;

    public ReservationService(ReservationRepository reservationRepository, TripRepository tripRepository, FareCalculatorProcessor fareCalculatorProcessor, TicketNumberProcessor ticketNumberProcessor) {
        this.reservationRepository = reservationRepository;
        this.tripRepository = tripRepository;
        this.fareCalculatorProcessor = fareCalculatorProcessor;
        this.ticketNumberProcessor = ticketNumberProcessor;
    }


    public List<AvailableTrip> displayFromOrigin(String origin, String destination, String date) {
        List<AvailableTrip> trips = tripRepository.displayTripsByDate(origin, destination, date);
        fareCalculatorProcessor.displayFareList(trips);
        return trips;
    }

    public AvailableTrip getTripById(int tripId) {
        return tripRepository.getSpecificTrip(tripId);
    }

    public void bookTrip(ReservedTrip newTrip, int selectedTripId) {
        double fare = Math.round(fareCalculatorProcessor.computeFare(selectedTripId) * newTrip.getQuantity() * 100.0) / 100.0;
        String ticketNumber = ticketNumberProcessor.generateTicketNumber();
        reservationRepository.bookTrip(ticketNumber, newTrip.getQuantity(), selectedTripId, newTrip.getFirstName(), newTrip.getLastname(), newTrip.getNotes(), newTrip.getDate(), newTrip.getTime(), fare);
        modifySeats(selectedTripId, newTrip.getQuantity(), true);

    }

    public void modifySeats(int id, int quantity, boolean reserve) {
        int seatCount;
        if (reserve) {
            seatCount = tripRepository.getSeatCount(id) - quantity;
        } else {
            seatCount = tripRepository.getSeatCount(id) + quantity;

        }
        tripRepository.updateSeats(seatCount, id);

    }


}
