package com.example.controller;

import com.example.model.AvailableTrip;
import com.example.model.ReservedTrip;
import com.example.services.ReservationService;
import com.example.services.ResponseMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    private final ReservationService reservationService;
    private final ResponseMessageService responseMessageService;

    public ReservationController(ReservationService reservationService, ResponseMessageService responseMessageService) {
        this.reservationService = reservationService;
        this.responseMessageService = responseMessageService;
    }



    @GetMapping("/trips/{origin}/{destination}")
    public List<AvailableTrip> displayTripsFromOrigin(
            @PathVariable("origin") String origin,
            @PathVariable("destination") String destination,
            @RequestParam String departureDate
    ) {
        return reservationService.displayFromOrigin(origin, destination, departureDate);
    }

    @PostMapping("/trips/{origin}/{destination}/book")
    public ResponseEntity<?> bookTrip(@RequestBody ReservedTrip newTrip, @RequestParam int selectedTrip) {
        reservationService.bookTrip(newTrip, selectedTrip);
        return responseMessageService.createMessage("Trip booked successfully", HttpStatus.ACCEPTED);
    }


}
