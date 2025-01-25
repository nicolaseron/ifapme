package org.example.calculatrice.controller;

import org.example.calculatrice.service.impl.HistoryServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HistoryController {
    private final HistoryServiceImpl historyService;

    public HistoryController(HistoryServiceImpl historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/history")
    public String getHistory() {
        return historyService.getHistory();
    }

    @DeleteMapping("history/{index}")
    public String deleteHistory(@PathVariable int index) {
        return historyService.deleteHistory(index);
    }
}
