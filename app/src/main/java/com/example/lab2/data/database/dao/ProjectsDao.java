package com.example.lab2.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lab2.data.database.entity.ProjectListItem;

import java.util.List;

@Dao
public interface ProjectsDao {
    @Query("SELECT * FROM projects_table")
    LiveData<List<ProjectListItem>> getProjectList();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ProjectListItem projectListItem);
    @Query("SELECT * FROM projects_table WHERE :id LIKE id")
    LiveData<ProjectListItem> getItem(int id);
}
