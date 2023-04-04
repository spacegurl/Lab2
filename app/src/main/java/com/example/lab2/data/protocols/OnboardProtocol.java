package com.example.lab2.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.models.ProjectListItem;

import java.util.List;

public interface OnboardProtocol {
    void addProjectItem(ProjectListItem projectListItem);
    LiveData<List<ProjectListItem>> getProjectList();

    void addArchiveItem (ArchiveListItem archiveListItem);
    LiveData<ArchiveListItem> getArchiveItem(int position);
    LiveData<List<ArchiveListItem>> getArchiveList();


}
