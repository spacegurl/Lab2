package com.example.lab2.data.models;

public class ProjectListItem {
    private int id_image;
    private String current_project;

    public ProjectListItem(int id_image, String current_project) {
        this.id_image = id_image;
        this.current_project = current_project;
    }

    public int getId_image() {
        return id_image;
    }

    public String getCompleted_project() {
        return current_project;
    }
}
