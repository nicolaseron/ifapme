package org.example.car.service;

import org.example.car.model.Model;

import java.util.List;

public interface ModelService {
    List<Model> getModelByMarque(String marque);
}
