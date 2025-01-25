package org.example.calculatrice.service.impl;

import org.example.calculatrice.Entity.History;
import org.example.calculatrice.service.HistoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    public List<History> historyList = new ArrayList<History>();

    @Override
    public void addHistory(String operation , Double result) {
        History history = new History(operation, result);
        historyList.add(history);
    }

    @Override
    public String deleteHistory(int index) {
        if (historyList.size() <= index) {
            return "Pas d'index avec le numéro donné !";
        }
        History history = historyList.get(index);
        if (history != null ) {
            historyList.remove(index);
            return "Ligne supprimée";
        }
        return "Il n'y a pas d'historique avec l'index donné.";
    }

    @Override
    public String getHistory() {
        StringBuilder str = new StringBuilder();
        int index = 0;
        for (History history : historyList) {
            str.append(index).append(") ").append(history.toString()).append("\n");
            index++;
        }
        return str.toString();
    }
}
