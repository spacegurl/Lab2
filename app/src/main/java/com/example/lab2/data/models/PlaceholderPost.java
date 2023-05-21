package com.example.lab2.data.models;

public class PlaceholderPost {
    private int userID;
    private int id;
    private String title;
    private String body;

    public PlaceholderPost(int userID, int id, String title, String body) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userID;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
}
