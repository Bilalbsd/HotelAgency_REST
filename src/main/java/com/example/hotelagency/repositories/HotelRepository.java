package com.example.hotelagency.repositories;

import com.example.hotelagency.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
