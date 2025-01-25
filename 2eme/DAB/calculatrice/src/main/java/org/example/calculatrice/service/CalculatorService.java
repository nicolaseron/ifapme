package org.example.calculatrice.service;

import java.util.List;

public interface CalculatorService {
    Double multiply(List<Double> numberList);

    Double sum(List<Double> numberList);

    Double subtract(List<Double> numberList);

    Double divide(List<Double> numberList);
}