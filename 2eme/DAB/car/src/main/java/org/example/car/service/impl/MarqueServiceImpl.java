package org.example.car.service.impl;

import org.example.car.model.Marque;
import org.example.car.repository.MarqueRepository;
import org.example.car.service.MarqueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueServiceImpl implements MarqueService {
    private final MarqueRepository marqueRepository;
    public MarqueServiceImpl(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }
    @Override
    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }
}
