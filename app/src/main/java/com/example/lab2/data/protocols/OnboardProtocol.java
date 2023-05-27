package com.example.lab2.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.data.models.PlaceholderPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OnboardProtocol {
    void addProjectItem(ProjectListItem projectListItem);
    LiveData<List<ProjectListItem>> getProjectList();

    void addArchiveItem (ArchiveListItem archiveListItem);
    LiveData<ArchiveListItem> getArchiveItem(int position);
    LiveData<ProjectListItem> getProjectItem(int position);
    LiveData<List<ArchiveListItem>> getArchiveList();

    LiveData<PlaceholderPost> getPost();

    LiveData<PlaceholderPost> pushPost();

    LiveData<List<PlaceholderPost>> getAllPosts();


}
