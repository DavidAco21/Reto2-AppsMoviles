package com.example.reto2.model;

import java.io.Serializable;

public class Album implements Serializable {

    private String title;
    private String cover_medium;

    public Album(String title, String cover_medium) {
        this.title = title;
        this.cover_medium = cover_medium;
    }

    public Album() {
    }

    public String getTitle() {
        return title;
    }

    public String getCover_medium() {
        return cover_medium;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover_medium(String cover_medium) {
        this.cover_medium = cover_medium;
    }
}
