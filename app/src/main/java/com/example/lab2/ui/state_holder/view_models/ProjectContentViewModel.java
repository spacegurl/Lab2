package com.example.lab2.ui.state_holder.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.data.models.PlaceholderPost;
import com.example.lab2.data.repositories.OnboardRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectContentViewModel extends AndroidViewModel {
    private final OnboardRepository repository = new OnboardRepository(getApplication());

    public LiveData<ProjectListItem> project_content_ld;

    public ProjectContentViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<PlaceholderPost> postLD = repository.getPost();

    public LiveData<PlaceholderPost> pushLD = repository.pushPost();

    public LiveData<List<PlaceholderPost>> getLD = repository.getAllPosts();

    public void getProjectContent(int position) {
        project_content_ld = repository.getProjectItem(position);
    }
}
