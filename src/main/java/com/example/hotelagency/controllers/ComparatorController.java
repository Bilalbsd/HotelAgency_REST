package com.example.hotelagency.controllers;

import com.example.hotelagency.models.Offer;
import com.example.hotelagency.services.ComparatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/comparator")
public class ComparatorController {

    @Autowired
    private ComparatorService comparatorService;

    @GetMapping("/compare")
    public ResponseEntity<List<Offer>> compareOffers(
            @RequestParam String country,
            @RequestParam String city,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyyy") Date endDate,
            @RequestParam int nbGuests,
            @RequestParam String roomType,
            @RequestParam int minStars) {

        List<Offer> comparisonResults = comparatorService.compareOffers(country, city, startDate, endDate, nbGuests, roomType, minStars);

        return ResponseEntity.ok(comparisonResults);
    }
}
