package com.example.hotelagency.repositories;

import com.example.hotelagency.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o WHERE o.availabilityDate BETWEEN :startDate AND :endDate AND o.room.nbBeds >= :nbGuests")
    List<Offer> findAvailableOffers(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("nbGuests") int nbGuests
    );

    @Query("SELECT o FROM Offer o WHERE o.availabilityDate BETWEEN :startDate AND :endDate " +
            "AND o.room.nbBeds >= :nbGuests " +
            "AND o.room.hotel.country = :country " +
            "AND o.room.hotel.city = :city " +
            "AND o.room.hotel.nbStars >= :hotelStars")
    List<Offer> findAvailableOffersComparision(
            @Param("country") String country,
            @Param("city") String city,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("nbGuests") int nbGuests,
            @Param("hotelStars") int hotelStars
    );


}
