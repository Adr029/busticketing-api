package com.example.services;

import com.example.exceptions.UnathorizedOperationException;
import com.example.model.AvailableTrip;
import com.example.model.ReservedTrip;
import com.example.processors.AdminCredentialsProcessor;
import com.example.repository.ReservationRepository;
import com.example.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final ReservationRepository reservationRepository;
    private final TripRepository tripRepository;

    private final AdminCredentialsProcessor adminCredentialsProcessor;

    public AdminService(ReservationRepository reservationRepository, TripRepository tripRepository, AdminCredentialsProcessor adminCredentialsProcessor) {
        this.reservationRepository = reservationRepository;
        this.tripRepository = tripRepository;
        this.adminCredentialsProcessor = adminCredentialsProcessor;
    }

    public List<AvailableTrip> displayAllTrips() {
        if (!adminCredentialsProcessor.isAdminValid())
        {
            throw new UnathorizedOperationException();
        }
        return tripRepository.getAllTrips();
    }

    public List<ReservedTrip> displayAllReservations() {
        if (!adminCredentialsProcessor.isAdminValid())
        {
            throw new UnathorizedOperationException();
        }
        return reservationRepository.getAllReservedTrips();
    }


    public boolean validateAdminCredentials (String username, String password)
    {
        adminCredentialsProcessor.setUsername(username);
        adminCredentialsProcessor.setPassword(password);
        adminCredentialsProcessor.checkAdminCredentials();
        return adminCredentialsProcessor.isAdminValid();
    }

    public void logOut()
    {
        adminCredentialsProcessor.setAdminValid(false);
    }
}
