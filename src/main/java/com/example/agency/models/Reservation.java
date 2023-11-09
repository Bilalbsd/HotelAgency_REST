package com.example.agency.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private Date startDate;
    private Date endDate;
    private int nbGuests;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Reservation() {}

    public Reservation(Date startDate, Date endDate, int nbGuests, Hotel hotel, Client client) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.nbGuests = nbGuests;
        this.hotel = hotel;
        this.client = client;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNbGuests() {
        return nbGuests;
    }

    public void setNbGuests(int nbGuests) {
        this.nbGuests = nbGuests;
    }
}
