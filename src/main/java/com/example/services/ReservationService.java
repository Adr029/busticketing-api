package com.example.services;

import com.example.model.AvailableTrip;
import com.example.model.ReservedTrip;
import com.example.processors.FareCalculatorProcessor;
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

    public ReservationService(ReservationRepository reservationRepository, TripRepository tripRepository, FareCalculatorProcessor fareCalculatorProcessor) {
        this.reservationRepository = reservationRepository;
        this.tripRepository = tripRepository;
        this.fareCalculatorProcessor = fareCalculatorProcessor;
    }

    //! TEST METHOD

    public List<AvailableTrip> displayAllTest() {
        return reservationRepository.getAllTrips();
    }

    public List<AvailableTrip> displayFromOrigin(String origin, String destination, String date) {
        List<AvailableTrip> trips = tripRepository.displayTripsByDate(origin, destination, date);
        fareCalculatorProcessor.displayFareList(trips);
        return trips;
    }

    public AvailableTrip getTripById(int tripId)
    {
        return tripRepository.getSpecificTrip(tripId);
    }
    //TODO generate ticket number
    public void bookTrip(ReservedTrip newTrip, int selectedTripId) {
        double fare = fareCalculatorProcessor.computeFare(selectedTripId) * newTrip.getQuantity();
        reservationRepository.bookTrip(newTrip.getTicketNumber(), newTrip.getQuantity(), selectedTripId, newTrip.getFirstName(), newTrip.getLastname(), newTrip.getNotes(), newTrip.getDate(), newTrip.getTime(), fare);
        modifySeats(selectedTripId, newTrip.getQuantity(), true);

    }

    public void modifySeats(int id, int quantity, boolean reserve)
    {
        int seatCount;
        if (reserve)
        {
            seatCount = tripRepository.getSeatCount(id) - quantity;
        }

        else
        {
           seatCount = tripRepository.getSeatCount(id) + quantity;

        }
        tripRepository.updateSeats(seatCount, id);

    }



}
