package org.example.car.service.impl;

import org.example.car.model.Model;
import org.example.car.repository.ModelRepository;
import org.example.car.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Model> getModelByMarque(String marque) {
        return modelRepository.findModelByMarque_Name_IgnoreCase(marque);
    }
}
