package com.example.hotelagency.repositories;

import com.example.hotelagency.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o WHERE o.availabilityDate BETWEEN :startDate AND :endDate AND o.nbBeds >= :nbGuests")
    List<Offer> findAvailableOffers(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("nbGuests") int nbGuests
    );
}
