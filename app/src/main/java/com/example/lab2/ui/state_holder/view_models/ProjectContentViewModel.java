package com.example.lab2.ui.state_holder.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.data.repositories.OnboardRepository;

public class ProjectContentViewModel extends AndroidViewModel {
    private final OnboardRepository repository = new OnboardRepository(getApplication());

    public LiveData<ProjectListItem> project_content_ld;

    public ProjectContentViewModel(@NonNull Application application) {
        super(application);
    }

    public void getProjectContent(int position) {
        project_content_ld = repository.getProjectItem(position);
    }
}
