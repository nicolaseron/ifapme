package org.example.car.repository;

import org.example.car.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    List<Model> findModelByMarque_Name_IgnoreCase(String marque);
}