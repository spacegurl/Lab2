package com.example.lab2.data;

import com.example.lab2.data.data_source.OnboardListsLocalDataSource;
import com.example.lab2.domain.OnboardRepository;
import com.example.lab2.domain.entity.ArchiveListItem;
import com.example.lab2.domain.entity.ProjectListItem;

import java.util.List;

public class OnboardRepositoryImplement implements OnboardRepository {

    private final OnboardListsLocalDataSource dataSource = new OnboardListsLocalDataSource();

    @Override
    public void addProjectItem(ProjectListItem projectListItem) {
        dataSource.addProjectItem(projectListItem);
    }

    @Override
    public List<ProjectListItem> getProjectList() {
        return getProjectList();
    }

    @Override
    public void addArchiveItem(ArchiveListItem archiveListItem) {
        dataSource.addArchiveItem(archiveListItem);
    }

    @Override
    public ArchiveListItem getArchiveItem(int position) {
        return dataSource.getArchiveList().get(position);
    }

    @Override
    public List<ArchiveListItem> getArchiveList() {
        return getArchiveList();
    }
}
