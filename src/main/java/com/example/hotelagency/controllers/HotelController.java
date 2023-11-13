package com.example.hotelagency.controllers;

import com.example.hotelagency.models.Offer;
import com.example.hotelagency.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/availability")
    public ResponseEntity<List<Offer>> getAvailability(
            @RequestParam Long agencyId,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            @RequestParam int nbGuests) {

        // Vérifier l'authentification de l'agence
        if (!hotelService.isAgencyAuthenticated(agencyId, username, password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Obtenir les offres disponibles
        List<Offer> availableOffers = hotelService.getAvailableOffers(startDate, endDate, nbGuests);

        return ResponseEntity.ok(availableOffers);
    }
}
