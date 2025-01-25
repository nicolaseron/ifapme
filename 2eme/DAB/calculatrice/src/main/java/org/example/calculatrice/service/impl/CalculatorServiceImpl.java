package org.example.calculatrice.service.impl;

import org.example.calculatrice.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final HistoryServiceImpl historyServiceImpl;

    public CalculatorServiceImpl(HistoryServiceImpl historyServiceImpl) {
        this.historyServiceImpl = historyServiceImpl;
    }

    public String constructOperation(List<Double> numberList, String operationType) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numberList.size(); i++) {
            if (i == numberList.size() - 1) {
                str.append(numberList.get(i));
            } else {
                str.append(numberList.get(i));
                str.append(operationType);
            }
        }
        return str.toString();
    }

    @Override
    public Double multiply(List<Double> numberList) {
        String operation = constructOperation(numberList, " * ");
        Double result = numberList.stream().reduce(1.0, (x, y) -> x * y);
        historyServiceImpl.addHistory(operation, result);
        return result;
    }

    ;

    @Override
    public Double sum(List<Double> numberList) {
        String operation = constructOperation(numberList, " + ");
        Double result = numberList.stream().reduce(0.0, Double::sum);
        historyServiceImpl.addHistory(operation, result);
        return result;
    }

    @Override
    public Double subtract(List<Double> numberList) {
        String operation = constructOperation(numberList, " - ");
        Double firstNum = numberList.get(0);
        Double result = numberList.stream().reduce(firstNum * 2, (x, y) -> x - y);
        historyServiceImpl.addHistory(operation, result);
        return result;
    }

    @Override
    public Double divide(List<Double> numberList) {
        String operation = constructOperation(numberList, " / ");
        Double firstNum = numberList.get(0);
        Double result = numberList.stream().reduce(Math.pow(firstNum, 2), (x, y) -> x / y);
        historyServiceImpl.addHistory(operation, result);
        return result;
    }
}
