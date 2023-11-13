package com.example.hotelagency.services;

import com.example.hotelagency.models.Agency;
import com.example.hotelagency.models.Offer;
import com.example.hotelagency.repositories.AgencyRepository;
import com.example.hotelagency.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    // Méthode pour vérifier l'authentification de l'agence
    public boolean isAgencyAuthenticated(Long agencyId, String username, String password) {
        Agency agency = agencyRepository.findById(agencyId).orElse(null);
        return agency != null && agency.getUsername().equals(username) && agency.getPassword().equals(password);
    }

    // Méthode pour obtenir les offres disponibles
    public List<Offer> getAvailableOffers(Date startDate, Date endDate, int nbGuests) {
        List<Offer> availableOffers = offerRepository.findAvailableOffers(startDate, endDate, nbGuests);
        List<Offer> offerList = new ArrayList<>();
        for (Offer offer : availableOffers) {
            Offer newOffer = new Offer();
            newOffer.setId(offer.getId());
            newOffer.setRoomType(offer.getRoomType());
            newOffer.setNbBeds(offer.getNbBeds());
            newOffer.setAvailabilityDate(offer.getAvailabilityDate());
            newOffer.setPrice(offer.getPrice());
            newOffer.setImage(offer.getImage());
            offerList.add(newOffer);
        }
        return offerList;
    }
}
