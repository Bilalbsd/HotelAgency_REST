package com.example.hotelagency.repositories;

import com.example.hotelagency.models.Offer;
import com.example.hotelagency.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
