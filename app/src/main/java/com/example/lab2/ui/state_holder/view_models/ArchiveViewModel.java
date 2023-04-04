package com.example.lab2.ui.state_holder.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.models.ProjectListItem;
import com.example.lab2.data.repositories.OnboardRepository;

import java.util.List;

public class ArchiveViewModel extends ViewModel {
    private final OnboardRepository repository = new OnboardRepository();

    public LiveData<List<ArchiveListItem>> archive_list_ld = repository.getArchiveList();
}
