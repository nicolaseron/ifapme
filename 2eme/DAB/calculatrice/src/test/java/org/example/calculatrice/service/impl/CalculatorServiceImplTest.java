package org.example.calculatrice.service.impl;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    HistoryServiceImpl historyService = new HistoryServiceImpl();
    CalculatorServiceImpl calculatorService = new CalculatorServiceImpl(historyService);

    List<Double> numberList = Arrays.asList(5.0, 2.0, 8.0);


    @Test
    void multiply() {
        assertEquals(80.0, calculatorService.multiply(numberList));
    }

    @Test
    void divide() {
        assertEquals(0.3125, calculatorService.divide(numberList));
    }

    @Test
    void subtract() {
        assertEquals(-5.0, calculatorService.subtract(numberList));
    }

    @Test
    void sum() {
        assertEquals(15.0, calculatorService.sum(numberList));
    }
}