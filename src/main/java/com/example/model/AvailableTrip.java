package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class AvailableTrip {
    @Id
    @Column("id")
    private int id;
    @Column("departuredate")
    private String departureDate;
    @Column("departuretime")

    private String departureTime;
    @Column("origin")

    private String origin;
    @Column("destination")

    private String destination;
    @Column("distance")

    private int distance;
    @Column("availableseats")

    private int availableSeats;
    @Column("bustype")
    private int busType;

    private double fare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getBusType() {
        return busType;
    }

    public void setBusType(int busType) {
        this.busType = busType;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "AvailableTrip{" +
                "id=" + id +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", availableSeats=" + availableSeats +
                ", busType=" + busType +
                ", fare=" + fare +
                '}';
    }
}
