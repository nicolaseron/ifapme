package org.example.car.repository;

import org.example.car.model.Marque;
import org.example.car.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarqueRepository extends JpaRepository<Marque, Integer> {
}
