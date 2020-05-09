package com.example.reto2.model;

import java.io.Serializable;

public class TrackContainer implements Serializable {

    private Track[] data;

    public TrackContainer(Track[] data) {
        this.data = data;
    }

    public TrackContainer() {
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }
}
