package com.example.services;

import com.example.model.AvailableTrip;
import com.example.model.ReservedTrip;
import com.example.repository.ReservationRepository;
import com.example.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final ReservationRepository reservationRepository;
    private final TripRepository tripRepository;

    public TestService(ReservationRepository reservationRepository, TripRepository tripRepository) {
        this.reservationRepository = reservationRepository;
        this.tripRepository = tripRepository;
    }

    //! TEST METHODS

    public List<AvailableTrip> displayAllTest() {
        return reservationRepository.getAllTrips();
    }

    public List<ReservedTrip> displayAllTestReserved() {
        return reservationRepository.getAllReservedTrips();
    }
}
