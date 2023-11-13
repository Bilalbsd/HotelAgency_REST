package com.example.hotelagency.repositories;

import com.example.hotelagency.models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

}
