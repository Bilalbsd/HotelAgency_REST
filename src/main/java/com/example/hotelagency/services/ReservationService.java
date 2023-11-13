package com.example.hotelagency.services;

import com.example.hotelagency.models.Agency;
import com.example.hotelagency.models.Offer;
import com.example.hotelagency.models.Reservation;
import com.example.hotelagency.repositories.AgencyRepository;
import com.example.hotelagency.repositories.OfferRepository;
import com.example.hotelagency.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    // Méthode pour vérifier l'authentification de l'agence
    public boolean isAgencyAuthenticated(Long agencyId, String username, String password) {
        Agency agency = agencyRepository.findById(agencyId).orElse(null);
        return agency != null && agency.getUsername().equals(username) && agency.getPassword().equals(password);
    }

    // Méthode pour effectuer la réservation
    public Reservation makeReservation(Long offerId, String firstname, String lastname) {
        Offer offer = offerRepository.findById(offerId).orElse(null);

        if (offer != null) {
            // Vérifie la disponibilité de l'offre
            if (isOfferAvailable(offer)) {
                // Crée une nouvelle réservation
                Reservation reservation = new Reservation();
                reservation.setOffer(offer);
                reservation.setStartDate(new Date());  // Date de début de la réservation (à ajuster selon les besoins)
                reservation.setEndDate(new Date());    // Date de fin de la réservation (à ajuster selon les besoins)

                // Enregistre la réservation dans la base de données
                Reservation savedReservation = reservationRepository.save(reservation);

                // Retourne une confirmation de la réservation avec la référence de la réservation
                Reservation response = new Reservation();
                response.setId(savedReservation.getId());
                response.setSuccess(true);
                response.setMessage("Réservation confirmée avec succès.");
                response.setReservationReference(savedReservation.getId().toString());

                response.setStartDate(savedReservation.getStartDate());
                response.setEndDate(savedReservation.getEndDate());
                //response.setOffer(savedReservation.getOffer());

                return response;
            } else {
                return createErrorResponse("L'offre n'est pas disponible pour la réservation.");
            }
        } else {
            return createErrorResponse("L'offre spécifiée n'existe pas.");
        }
    }

    // Méthode pour vérifier la disponibilité de l'offre
    private boolean isOfferAvailable(Offer offer) {
        // Vérifie si la date de disponibilité de l'offre est dans le futur
        Date currentDate = new Date();
        Date availabilityDate = offer.getAvailabilityDate();

        return availabilityDate != null && availabilityDate.after(currentDate);
    }

    // Méthode utilitaire pour créer une réponse d'erreur
    private Reservation createErrorResponse(String message) {
        Reservation response = new Reservation();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }
}
