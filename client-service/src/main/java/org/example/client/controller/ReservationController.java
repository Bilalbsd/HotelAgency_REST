package org.example.client.controller;

import org.example.Offer;
import org.example.client.service.ReservationClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    final ReservationClientService reservationClientService;


    public ReservationController(ReservationClientService reservationClientService) {
        this.reservationClientService = reservationClientService;
    }

    @PostMapping("/makereservation")
    public List<Offer> makeReservation(

    ) {

    }

}
