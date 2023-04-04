package com.example.lab2.ui.state_holder.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.ProjectListItem;
import com.example.lab2.data.repositories.OnboardRepository;

import java.util.List;

public class ProjectContentViewModel extends ViewModel {
    private final OnboardRepository repository = new OnboardRepository();

    public LiveData<ProjectListItem> project_content_ld;

    public void getProjectContent(int position) {
        project_content_ld = repository.getProjectItem(position);
    }
}
