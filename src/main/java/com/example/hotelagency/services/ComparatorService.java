package com.example.hotelagency.services;

import com.example.hotelagency.models.Offer;
import com.example.hotelagency.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ComparatorService {

    @Autowired
    public OfferRepository offerRepository;

    public List<Offer> compareOffers(String country, String city, Date startDate, Date endDate, int nbGuests, String roomType, int minStars) {

        return Collections.emptyList();
    }
}
