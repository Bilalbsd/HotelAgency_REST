package com.example.hotelagency.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date availabilityDate;
    private double price;
    private boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Offer() {}

    public Offer(Date availabilityDate, double price, boolean isReserved, Agency agency, Room room) {
        this.availabilityDate = availabilityDate;
        this.price = price;
        this.isReserved = isReserved;
        this.agency = agency;
        this.room = room;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
