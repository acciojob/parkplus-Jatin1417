package com.driver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(value = EnumType.STRING)
    SpotType spotType;

    int pricePerHour;
    Boolean occupied;

    @ManyToOne
    @JoinColumn
    public ParkingLot parkingLot;

    @OneToMany(mappedBy = "spot",cascade = CascadeType.ALL)
    List<Reservation> reservationList;

    public Spot(SpotType spotType, int pricePerHour, Boolean occupied) {
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.occupied = occupied;
    }

    public Spot(ParkingLot parkingLot,Integer numberOfWheels, Integer pricePerHour) {
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.parkingLot = parkingLot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Spot() {
    }
}
