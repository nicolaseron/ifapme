package org.example;

public class Magazine extends Media {
    private int nbrOfPages;

    public Magazine(String title, Boolean isAvailable, int nbrOfPages) {
        super(title, isAvailable);
        this.nbrOfPages = nbrOfPages;
    }

    public int getNbrOfPages() {
        return nbrOfPages;
    }

    public void setNbrOfPages(int nbrOfPages) {
        this.nbrOfPages = nbrOfPages;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "nbrOfPages=" + nbrOfPages + " " + getTitle() + " " + getAvailable() +
                '}';
    }
}