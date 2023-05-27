package com.example.lab2.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lab2.data.api.RetrofitFactory;
import com.example.lab2.data.api.TypeCodeAPI;
import com.example.lab2.data.data_source.OnboardListsLocalDataSource;
import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.data.models.PlaceholderPost;
import com.example.lab2.data.protocols.OnboardProtocol;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OnboardRepository implements OnboardProtocol {
    private final Context context;

    private final OnboardListsLocalDataSource dataSource;

    public OnboardRepository(Context context) {
        this.context = context;
        dataSource = new OnboardListsLocalDataSource(context);
    }

    @Override
    public void addProjectItem(ProjectListItem projectListItem) {
        dataSource.addProjectItem(projectListItem);
    }

    @Override
    public LiveData<List<ProjectListItem>> getProjectList() {
        return dataSource.getProjectList();
    }

    @Override
    public void addArchiveItem(ArchiveListItem archiveListItem) {
        dataSource.addArchiveItem(archiveListItem);
    }

    @Override
    public LiveData<ArchiveListItem> getArchiveItem(int position) {
        return dataSource.getArchiveItem(position);
    }

    @Override
    public LiveData<ProjectListItem> getProjectItem(int position) {
        return dataSource.getProjectItem(position);
    }

    @Override
    public LiveData<List<ArchiveListItem>> getArchiveList() {
        return getArchiveList();
    }

    @Override
    public LiveData<PlaceholderPost> getPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.getPost();

        MutableLiveData<PlaceholderPost> postLD = new MutableLiveData<>();
        call.enqueue(new Callback<PlaceholderPost>() {
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
        return postLD;
    }

    @Override
    public LiveData<PlaceholderPost> pushPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.pushPost(new PlaceholderPost(47, 65, "This is the way", "UK"));

        MutableLiveData<PlaceholderPost> pushLD = new MutableLiveData<>();
        call.enqueue(new Callback<PlaceholderPost>() {
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
        return pushLD;
    }

    @Override
    public LiveData<List<PlaceholderPost>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<List<PlaceholderPost>> call = typeCodeAPI.getAllPosts();

        MutableLiveData<List<PlaceholderPost>> getLD = new MutableLiveData<>();
        call.enqueue(new Callback<List<PlaceholderPost>>() {
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
        return getLD;
    }
}
