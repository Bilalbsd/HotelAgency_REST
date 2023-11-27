package com.example.hotelagency.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private int nbBeds;
    private String image;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Room() {}

    public Room(String roomType, int nbBeds, String image, Hotel hotel) {
        this.roomType = roomType;
        this.nbBeds = nbBeds;
        this.image = image;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
