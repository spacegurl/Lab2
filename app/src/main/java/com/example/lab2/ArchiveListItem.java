package com.example.lab2;

public class ArchiveListItem {
    private int id_image;
    private String completed_project;

    public ArchiveListItem(int id_image, String completed_project) {
        this.id_image = id_image;
        this.completed_project = completed_project;
    }

    public int getId_image() {
        return id_image;
    }

    public String getCompleted_project() {
        return completed_project;
    }
}
