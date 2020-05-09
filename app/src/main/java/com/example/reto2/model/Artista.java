package com.example.reto2.model;

import java.io.Serializable;

public class Artista implements Serializable {

    private String name;

    public Artista(String name) {
        this.name = name;
    }

    public Artista() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
