package com.example.processors;

import com.example.model.AvailableTrip;
import com.example.repository.TripRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FareCalculatorProcessor {
    private final TripRepository tripRepository;
    private final double minimumFare = 11.00;
    private double additionalFare;
    private int distance;
    private int busType;

    /*
    regular non AC = 1.90
    regular AC = 2.10
    deluxe = 2.25
    super deluxe = 2.35
    luxury = 2.90
     */
    public FareCalculatorProcessor(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public void displayFareList(List<AvailableTrip> tripList) {
        for (AvailableTrip trip : tripList) {
            distance = trip.getDistance();
            busType = trip.getBusType();
            setAdditionalFare(busType);
            trip.setFare(calculateTotalFare());
        }
    }

    public double computeFare(int tripId) {
        AvailableTrip trip = tripRepository.getSpecificTrip(tripId);
        distance = trip.getDistance();
        busType = trip.getBusType();
        setAdditionalFare(busType);
        return calculateTotalFare();
    }


    private void setAdditionalFare(int busType) {
        switch (busType) {
            case 0:
                additionalFare = 1.90;
                break;
            case 1:
                additionalFare = 2.10;
                break;
            case 2:
                additionalFare = 2.25;
                break;
            case 3:
                additionalFare = 2.35;
                break;
            case 4:
                additionalFare = 2.90;
                break;
            default:
                break;
        }
    }

    private double calculateTotalFare() {
        return Math.round((minimumFare + (additionalFare * distance)) * 100.0) / 100.0;
    }
}


