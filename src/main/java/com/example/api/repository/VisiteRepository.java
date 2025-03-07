package com.example.api.repository;

import com.example.api.model.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteRepository extends JpaRepository<Visite, Long> {
}
