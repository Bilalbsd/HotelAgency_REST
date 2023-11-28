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
import java.util.Optional;

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
            newOffer.setAvailabilityDate(offer.getAvailabilityDate());
            newOffer.setPrice(offer.getPrice() * offer.getAgency().getDiscount());
            System.out.println("Offer agence : "+offer.getAgency());
            System.out.println("Offer room : "+offer.getRoom());
            newOffer.setAgency(offer.getAgency());
            // print(offer.getAgency()) --> Agency objecY
            newOffer.setRoom(offer.getRoom());
            System.out.println("testttttttttt: "+offer.getRoom().getHotel());
            newOffer.getRoom().setHotel(offer.getRoom().getHotel());
            offerList.add(newOffer);
        }
        return offerList;
    }

    // Méthode pour obtenir les offres disponibles
    public List<Offer> getAvailableOffersComparision(String country, String city, Date startDate, Date endDate, int nbGuests, int minStars) {
        List<Offer> availableOffers = offerRepository.findAvailableOffers(startDate, endDate, nbGuests);
        List<Offer> offerList = new ArrayList<>();
        /*for (Offer offer : availableOffers) {
            Offer newOffer = new Offer();
            newOffer.setId(offer.getId());
            newOffer.setAvailabilityDate(offer.getAvailabilityDate());
            newOffer.setPrice(offer.getPrice());
            offerList.add(newOffer);
        }*/
        return offerList;
    }

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }
}
