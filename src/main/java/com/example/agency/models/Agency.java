package com.example.agency.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Agency {
    @Id
    @GeneratedValue
    private Long id;
    private String agencyName;
    private String username;
    private String password;

    // Une agence peut avoir plusieurs offres, mais chaque offre appartient à une seule agence
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Offer> offers;

    public Agency() {}

    public Agency(String agencyName, String username, String password, List<Offer> offfers) {
        this.agencyName = agencyName;
        this.username = username;
        this.password = password;
        this.offers = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
