package com.example.lab2.ui.state_holder.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.repositories.OnboardRepository;

import java.util.List;

public class ArchiveViewModel extends AndroidViewModel {
    private final OnboardRepository repository = new OnboardRepository(getApplication());

    public LiveData<List<ArchiveListItem>> archive_list_ld = repository.getArchiveList();

    public ArchiveViewModel(@NonNull Application application) {
        super(application);
    }
}
