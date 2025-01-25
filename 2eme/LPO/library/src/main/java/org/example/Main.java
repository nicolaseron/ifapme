package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> actorList = new ArrayList<>();
        actorList.add("Will Smith");
        actorList.add("Jacky Chan");
        actorList.add("Dany Boon");

        Magazine magazine = new Magazine("SportMagazine", true, 25);
        DVD dvd = new DVD("Avatar", false, actorList);
        Book book = new Book("Harry Potter", true, "J.K. Rowling");

        Library<Media> library = new Library<>();
        library.AddMedia(magazine);
        library.AddMedia(dvd);
        library.AddMedia(book);

        System.out.println(library);

        library.removeMedia(dvd);
        System.out.println(library);

    }
}