package org.example;

public class Book extends Media {
    private String author;

    public Book(String title, Boolean isAvailable, String author) {
        super(title, isAvailable);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + " " + getTitle() + " " + getAvailable() +
                '}';
    }
}
