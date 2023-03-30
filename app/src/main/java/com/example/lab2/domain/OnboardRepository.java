package com.example.lab2.domain;

import com.example.lab2.domain.entity.ArchiveListItem;
import com.example.lab2.domain.entity.ProjectListItem;

import java.util.List;

public interface OnboardRepository {
    void addProjectItem(ProjectListItem projectListItem);
    List<ProjectListItem> getProjectList();

    void addArchiveItem (ArchiveListItem archiveListItem);
    ArchiveListItem getArchiveItem(int position);
    List<ArchiveListItem> getArchiveList();


}
