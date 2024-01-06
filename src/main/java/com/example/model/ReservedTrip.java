package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("reservedtrips")
public class ReservedTrip {
    @Id
    @Column("id")
    private int id;
    @Column("ticketnumber")
    private String ticketNumber;
    @Column("tripid")
    private int tripId;
    @Column("quantity")
    private int quantity;
    @Column("firstname")
    private String firstName;
    @Column("lastname")
    private String lastname;
    @Column("notes")
    private String notes;
    @Column("date")
    private String date;
    @Column("time")
    private String time;
    @Column("fare")
    private double fare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "ReservedTrip{" +
                "id=" + id +
                ", ticketNumber=" + ticketNumber +
                ", tripId=" + tripId +
                ", quantity=" + quantity +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", notes='" + notes + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", fare=" + fare +
                '}';
    }
}
