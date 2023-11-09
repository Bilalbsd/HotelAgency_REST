package com.example.agency.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {
    @Id
    @GeneratedValue
    private Long id;
    private String hotelName;
    private String address;
    private int nbStars;

    // Un hôtel peut avoir plusieurs chambres, et chaque chambre appartient à un seul hôtel.
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;

    // Un hôtel peut avori plusieurs réservations, mais une réservation est associée à un seul hôtel.
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Hotel() {}

    public Hotel(String hotelName, String address, int nbStars, List<Room> rooms, List<Reservation> reservations) {
        this.hotelName = hotelName;
        this.address = address;
        this.nbStars = nbStars;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNbStars() {
        return nbStars;
    }

    public void setNbStars(int nbStars) {
        this.nbStars = nbStars;
    }
}
