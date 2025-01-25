package org.example;

public abstract class Media implements Rent {
    private String title;
    private Boolean isAvailable;

    public Media(String title, Boolean isAvailable) {
        this.title = title;
        this.isAvailable = isAvailable;
    }

    @Override
    public void rent() {
        this.isAvailable = false;
    }

    @Override
    public void returning() {
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

}
