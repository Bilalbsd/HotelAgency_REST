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
public class ComparateurController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/comparateur")
    public ResponseEntity<List<Offer>> compareOffers(
            @RequestParam String country,
            @RequestParam String city,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam int nbGuests,
            @RequestParam int minStars) {

        // Obtenez les offres de chaque agence pour la ville spécifiée
        List<Offer> offerList = hotelService.getAvailableOffersComparision(country, city, startDate, endDate, nbGuests, minStars);

        return new ResponseEntity<>(offerList, HttpStatus.OK);
    }
}
