package com.example.repository;

import com.example.model.AvailableTrip;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepository extends CrudRepository<AvailableTrip, Integer> {

    /* SCHEMA

    CREATE TABLE IF NOT EXISTS availabletrips (
        id INT AUTO_INCREMENT PRIMARY KEY,
        departuredate VARCHAR(30),
        departuretime VARCHAR(30),
        origin VARCHAR(30),
        destination VARCHAR(30),
        availableseats INT,
        bustype INT,
        distance INT

    );
     */

    @Query("SELECT * FROM availabletrips")
    List<AvailableTrip> getAllTrips();
    @Query("SELECT * FROM availabletrips WHERE origin = :origin AND destination = :destination AND departuredate = :departureDate")
    List<AvailableTrip> displayTripsByDate(String origin, String destination, String departureDate);

    @Query("SELECT * FROM availabletrips WHERE id = :id")
    AvailableTrip getSpecificTrip(int id);

    @Query("SELECT availableseats FROM availabletrips WHERE id = :id")
    int getSeatCount(int id);

    @Modifying
    @Query("UPDATE availabletrips SET availableseats = :seats WHERE id = :id")
    void updateSeats(int seats, int id);
}
