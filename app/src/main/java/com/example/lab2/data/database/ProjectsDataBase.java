package com.example.lab2.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lab2.data.database.dao.ProjectsDao;
import com.example.lab2.data.database.entity.ProjectListItem;

@Database(entities = {ProjectListItem.class}, version = 1, exportSchema = false)
public abstract class ProjectsDataBase extends RoomDatabase {
    private static volatile ProjectsDataBase INSTANCE;

    public abstract ProjectsDao projectsDao();

    public static ProjectsDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProjectsDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ProjectsDataBase.class, "project_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
