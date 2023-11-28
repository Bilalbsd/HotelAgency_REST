package com.example.hotelagency.services;

import com.example.hotelagency.models.*;
import com.example.hotelagency.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    // Méthode pour vérifier l'authentification de l'agence
    public boolean isAgencyAuthenticated(Long agencyId, String username, String password) {
        Agency agency = agencyRepository.findById(agencyId).orElse(null);
        return agency != null && agency.getUsername().equals(username) && agency.getPassword().equals(password);
    }

    public Long findClientId(String firstname, String lastname, String cardNumber, String ccv) {
        // Utilisez votre repository client pour trouver le client en fonction des informations fournies
        // Assurez-vous que la méthode findBy... existe dans votre clientRepository
        Client client = clientRepository.findByFirstnameAndLastnameAndCardNumberAndCcv(firstname, lastname, cardNumber, ccv);
        // Retourne l'ID du client s'il est trouvé, sinon retourne null
        return (client != null) ? client.getId() : null;
    }


    // Méthode pour effectuer la réservation
    public Reservation makeReservation(Long offerId, Long clientId) {
        // Récupère l'offre par ID
        Offer offer = offerRepository.findById(offerId).orElse(null);
        Client client = clientRepository.findById(clientId).orElse(null);
        if (offer != null) {
            // Vérifie la disponibilité de l'offre
            if (offer.isReserved() == false) {
                // Crée une nouvelle réservation
                Reservation reservation = new Reservation();
                reservation.setSuccess(true);
                reservation.setMessage("Réservation confirmée avec succès.");
                reservation.setReservationReference(reservation.getId());
                reservation.setOffer(offer);
                reservation.setClient(client);
                reservation.setHotel(offer.getRoom().getHotel());

                // On définie que l'offre a été réservé et donc n'est plus disponible !
                reservation.getOffer().setReserved(true);

                // On définie le prix de l'offre en fonction du "discount" de l'Agence à laquelle elle est reliée !
                reservation.getOffer().setPrice(reservation.getOffer().getPrice() * reservation.getOffer().getAgency().getDiscount());

                // Enregistre la réservation dans la base de données
                Reservation savedReservation = reservationRepository.save(reservation);

                // Retourne une confirmation de la réservation avec la référence de la réservation
                Reservation response = new Reservation();
                response.setId(savedReservation.getId());
                response.setSuccess(true);
                response.setMessage("Réservation confirmée avec succès.");
                response.setReservationReference(savedReservation.getId());

                response.getHotel();

                System.out.println("getID : " + savedReservation.getId());
                System.out.println("getOffer : " + savedReservation.getOffer());
                System.out.println("getClient : " + savedReservation.getClient());
                System.out.println("getHotel : " + savedReservation.getHotel());

                response.setOffer(savedReservation.getOffer());
                response.setClient(savedReservation.getClient());
                //response.setHotel(savedReservation.getHotel());

                return response;
            } else {
                // L'offre n'est pas disponible
                return createErrorResponse("L'offre n'est pas disponible pour la réservation.");
            }
        } else {
            // L'offre n'existe pas
            return createErrorResponse("L'offre spécifiée n'existe pas.");
        }
    }

    // Méthode utilitaire pour créer une réponse d'erreur
    private Reservation createErrorResponse(String message) {
        Reservation response = new Reservation();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }
}
