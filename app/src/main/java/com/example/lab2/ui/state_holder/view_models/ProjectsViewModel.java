package com.example.lab2.ui.state_holder.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.data.repositories.OnboardRepository;

import java.util.List;

public class ProjectsViewModel extends AndroidViewModel {
    private final OnboardRepository repository = new OnboardRepository(getApplication());

    public LiveData<List<ProjectListItem>> project_list_ld = repository.getProjectList();

    public ProjectsViewModel(@NonNull Application application) {
        super(application);
    }
}
