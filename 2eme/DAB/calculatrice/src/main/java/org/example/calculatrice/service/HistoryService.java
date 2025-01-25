package org.example.calculatrice.service;

public interface HistoryService {

    void addHistory(String operation, Double result);

    String deleteHistory(int index);

    String getHistory();

}
