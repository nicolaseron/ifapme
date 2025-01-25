package org.example;

import java.util.List;

public class DVD extends Media {
    private List<String> actors;

    public DVD(String title, Boolean isAvailable, List<String> actors) {
        super(title, isAvailable);
        this.actors = actors;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "actors=" + actors + " " + getTitle() + " " + getAvailable() +
                '}';
    }
}
