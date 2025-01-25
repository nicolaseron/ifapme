package org.example.calculatrice.service.impl;

import org.example.calculatrice.Entity.History;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryServiceImplTest {

    HistoryServiceImpl historyService = new HistoryServiceImpl();

    int previousSize = historyService.historyList.size();

    private final String operation = "5 * 5 * 5";
    private final Double result = 125.0;
    private final History history = new History(operation, result);

    @Test
    void addHistory() {
        historyService.addHistory(history.getOperation(), history.getResult());
        assertEquals(historyService.historyList.get(0).getOperation(), history.getOperation());
        assertEquals(historyService.historyList.get(0).getResult(), history.getResult());
    }

    @Test
    void getHistory() {
        historyService.addHistory(history.getOperation(), history.getResult());
        assertEquals(previousSize + 1, historyService.historyList.size());
    }

    @Test
    void deleteHistory() {
        historyService.deleteHistory(0);
        assertEquals(previousSize, historyService.getHistory().length());
    }
}