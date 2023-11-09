package com.example.agency.models;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private int nbBeds;
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Room() {}

    public Room(int nbBeds, double price, Hotel hotel) {
        this.nbBeds = nbBeds;
        this.price = price;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbBeds() {
        return nbBeds;
    }

    public void setNbBeds(int nbBeds) {
        this.nbBeds = nbBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
