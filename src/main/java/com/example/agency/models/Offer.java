package com.example.agency.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class Offer {
    @Id
    @GeneratedValue
    private Long id;
    private String roomType;
    private int nbBeds;
    private Date availabilityDate;
    private double price;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    public Offer() {}

    public Offer(String roomType, int nbBeds, Date availabilityDate, double price, Agency agency) {
        this.roomType = roomType;
        this.nbBeds = nbBeds;
        this.availabilityDate = availabilityDate;
        this.price = price;
        this.agency = agency;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNbBeds() {
        return nbBeds;
    }

    public void setNbBeds(int nbBeds) {
        this.nbBeds = nbBeds;
    }

    public Date getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(Date availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
