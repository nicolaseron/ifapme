package com.example.spring_security.repository;

import com.example.spring_security.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    Optional<Personne> findByUsername(String username);
}
