package com.example.hotelagency.controllers;

import com.example.hotelagency.models.Reservation;
import com.example.hotelagency.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity<Reservation> makeReservation(
            @RequestParam Long agencyId,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam Long offerId,
            @RequestParam String firstname,
            @RequestParam String lastname) {

        // Vérifier l'authentification de l'agence
        if (!reservationService.isAgencyAuthenticated(agencyId, username, password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Effectuer la réservation
        Reservation response = reservationService.makeReservation(offerId, firstname, lastname);

        // Retourner la réponse
        return ResponseEntity.ok(response);
    }
}
