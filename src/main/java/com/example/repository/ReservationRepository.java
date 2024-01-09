package com.example.repository;

import com.example.model.AvailableTrip;
import com.example.model.ReservedTrip;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<ReservedTrip, Integer> {

    @Query("SELECT * FROM reservedtrips WHERE ticketnumber = :ticketNumber AND lastname = :lastName")
    ReservedTrip findReservation(String ticketNumber, String lastName);

    //! TEST METHOD

    @Query("SELECT * FROM availabletrips")
    List<AvailableTrip> getAllTrips();
    //! TEST METHOD

    @Query("SELECT * FROM reservedtrips")
    List<ReservedTrip> getAllReservedTrips();

    @Modifying
    @Query("INSERT INTO reservedtrips VALUES (NULL, :ticketnumber, :quantity, :tripid, :firstname, :lastname, :notes, :date, :time, :fare)")
    void bookTrip(String ticketnumber, int quantity, int tripid, String firstname, String lastname, String notes, String date, String time, double fare);
    @Modifying
    @Query("DELETE FROM reservedtrips WHERE ticketnumber = :ticketNumber")
    void cancelBooking(String ticketNumber);


    @Modifying
    @Query("UPDATE reservedtrips SET date = :date, time = :time, tripid = :tripId WHERE ticketnumber = :ticketNumber")
    void updateBooking(String date, String time, String ticketNumber, int tripId);


    //pwedeng instead of delete, update status as cancelled

    /*

CREATE TABLE IF NOT EXISTS reservedtrips (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ticketnumber INT,
    quantity INT,
    tripid INT,
    firstname VARCHAR(30),
    lastname VARCHAR(30),
    notes VARCHAR(150),
    date VARCHAR(30),
    time VARCHAR(30),
    fare DOUBLE

);

     */

}
