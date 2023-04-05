package com.example.lab2.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "projects_table")
public class ProjectListItem {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public Integer uid;
    private int id_image;
    private String current_project;

    public ProjectListItem(int id_image, String current_project) {
        this.id_image = id_image;
        this.current_project = current_project;
    }

    public int getId_image() {
        return id_image;
    }

    public String getCurrent_project() {
        return current_project;
    }
}
