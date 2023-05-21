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
        repository.getPost().enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()) {
                    PlaceholderPost post = response.body();
                    postLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {

            }
        });

        repository.pushPost(new PlaceholderPost(47, 65, "This is the way", "UK")).enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()) {
                    PlaceholderPost post = response.body();
                    pushLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {

            }
        });
        repository.getAllPosts().enqueue(new Callback<List<PlaceholderPost>>() {
            @Override
            public void onResponse(Call<List<PlaceholderPost>> call, Response<List<PlaceholderPost>> response) {
                if (response.isSuccessful()) {
                    List<PlaceholderPost> post = response.body();
                    getLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<List<PlaceholderPost>> call, Throwable t) {

            }
        });
    }

    private MutableLiveData<PlaceholderPost> postLD = new MutableLiveData<>();

    public LiveData<PlaceholderPost> getPostLD() {
        return postLD;
    }

    private MutableLiveData<PlaceholderPost> pushLD = new MutableLiveData<>();

    public LiveData<PlaceholderPost> getPushLD() {
        return pushLD;
    }

    private MutableLiveData<List<PlaceholderPost>> getLD = new MutableLiveData<>();

    public LiveData<List<PlaceholderPost>> getListLD() {
        return getLD;
    }
    public void getProjectContent(int position) {
        project_content_ld = repository.getProjectItem(position);
    }
}
