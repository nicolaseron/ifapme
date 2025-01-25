package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library<T>  {
    private final List<T> mediaList = new ArrayList<T>();

    public Library() {
    }

    public void AddMedia(T media) {
        mediaList.add(media);
    }

    public void removeMedia(T media) {
        mediaList.remove(media);
    }

    @Override
    public String toString() {
        return "Library{" +
                "mediaList=" + mediaList +
                '}';
    }
}
