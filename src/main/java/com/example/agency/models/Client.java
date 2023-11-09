package com.example.agency.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String cardNumber;

    // Un client peut avoir plusieurs réservations, mais chaque réservation et associée à un seul client
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Client() {}

    public Client(String firstname, String lastname, String cardNumber, List<Reservation> reservations) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cardNumber = cardNumber;
        this.reservations = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
