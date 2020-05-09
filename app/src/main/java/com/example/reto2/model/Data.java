package com.example.reto2.model;

public class Data {

    private String title;
    private User user;
    private String id;
    private String nb_tracks;
    private String picture;
    private String picture_big;
    private String description;
    private String fans;
    private TrackContainer tracks;

    public Data(String title, User user, String nb_tracks, String picture, String fans, String picture_big, String id, TrackContainer tracks) {
        this.title = title;
        this.user = user;
        this.nb_tracks = nb_tracks;
        this.picture = picture;
        this.description = description;
        this.fans = fans;
        this.picture_big = picture_big;
        this.id = id;
        this.tracks = tracks;
    }

    public Data() {
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setNbSongs(String nb_tracks) {
        this.nb_tracks = nb_tracks;
    }



    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNb_tracks() {
        return nb_tracks;
    }

    public String getPicture() {
        return picture;
    }

    public void setNb_tracks(String nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public String getFans() {
        return fans;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getPicture_big() {
        return picture_big;
    }

    public void setPicture_big(String picture_big) {
        this.picture_big = picture_big;
    }

    public TrackContainer getTracks() {
        return tracks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTracks(TrackContainer tracks) {
        this.tracks = tracks;
    }
}
