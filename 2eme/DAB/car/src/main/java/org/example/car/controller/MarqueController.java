package org.example.car.controller;

import org.example.car.model.Marque;
import org.example.car.model.Model;
import org.example.car.service.impl.MarqueServiceImpl;
import org.example.car.service.impl.ModelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/marque")
public class MarqueController {
    private MarqueServiceImpl marqueService;
    private ModelServiceImpl modelService;

    public MarqueController(MarqueServiceImpl marqueService , ModelServiceImpl modelService) {
        this.marqueService = marqueService;
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public List<Marque> getAllMarques(){
        return marqueService.getAllMarques();
    }
    @GetMapping("/modelByMarque/{marque}")
    public List<Model> getModelByMarque(@PathVariable String marque){
        return modelService.getModelByMarque(marque);
    }
}
