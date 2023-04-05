package com.example.lab2.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.lab2.data.data_source.OnboardListsLocalDataSource;
import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.data.protocols.OnboardProtocol;

import java.util.List;

public class OnboardRepository implements OnboardProtocol {
    private final Context context;

    private final OnboardListsLocalDataSource dataSource;

    public OnboardRepository(Context context) {
        this.context = context;
        dataSource = new OnboardListsLocalDataSource(context);
    }

    @Override
    public void addProjectItem(ProjectListItem projectListItem) {
        dataSource.addProjectItem(projectListItem);
    }

    @Override
    public LiveData<List<ProjectListItem>> getProjectList() {
        return dataSource.getProjectList();
    }

    @Override
    public void addArchiveItem(ArchiveListItem archiveListItem) {
        dataSource.addArchiveItem(archiveListItem);
    }

    @Override
    public LiveData<ArchiveListItem> getArchiveItem(int position) {
        return dataSource.getArchiveItem(position);
    }

    @Override
    public LiveData<ProjectListItem> getProjectItem(int position) {
        return dataSource.getProjectItem(position);
    }

    @Override
    public LiveData<List<ArchiveListItem>> getArchiveList() {
        return getArchiveList();
    }
}
