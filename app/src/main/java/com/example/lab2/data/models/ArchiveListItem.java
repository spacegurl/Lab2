package com.example.lab2.data.models;

public class ArchiveListItem {
    private int id_image; // поле для изображения
    private String completed_project; // поле для текста

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
