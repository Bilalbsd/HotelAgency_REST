package com.example.hotelagency.repositories;

import com.example.hotelagency.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
