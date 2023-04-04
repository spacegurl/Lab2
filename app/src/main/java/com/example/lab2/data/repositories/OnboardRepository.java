package com.example.lab2.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.lab2.data.data_source.OnboardListsLocalDataSource;
import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.models.ProjectListItem;
import com.example.lab2.data.protocols.OnboardProtocol;

import java.util.List;

public class OnboardRepository implements OnboardProtocol {

    private final OnboardListsLocalDataSource dataSource = new OnboardListsLocalDataSource();

    @Override
    public void addProjectItem(ProjectListItem projectListItem) {
        dataSource.addProjectItem(projectListItem);
    }

    @Override
    public LiveData<List<ProjectListItem>> getProjectList() {
        return getProjectList();
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
