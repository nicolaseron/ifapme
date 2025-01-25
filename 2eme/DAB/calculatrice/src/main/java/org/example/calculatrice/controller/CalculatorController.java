package org.example.calculatrice.controller;

import org.example.calculatrice.service.impl.CalculatorServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculatorController {
    private final CalculatorServiceImpl calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculatrice/multiply")
    public Double multiply(@RequestBody List<Double> numberList) {
        return calculatorService.multiply(numberList);
    }

    @PostMapping("/calculatrice/sum")
    public Double sum(@RequestBody List<Double> numberList) {
        return calculatorService.sum(numberList);
    }

    @PostMapping("/calculatrice/subtract")
    public Double subtract(@RequestBody List<Double> numberList) {
        return calculatorService.subtract(numberList);
    }

    @PostMapping("/calculatrice/divide")
    public Double divide(@RequestBody List<Double> numberList) {
        return calculatorService.divide(numberList);
    }
}
