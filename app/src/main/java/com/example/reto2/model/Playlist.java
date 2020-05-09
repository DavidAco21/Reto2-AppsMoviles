package com.example.reto2.model;

public class Playlist {

    private Data[] data;


    public Playlist(Data[] data) {
        this.data = data;
    }

    public Playlist() {
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
