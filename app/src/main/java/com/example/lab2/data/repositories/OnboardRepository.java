package com.example.lab2.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.lab2.data.api.RetrofitFactory;
import com.example.lab2.data.api.TypeCodeAPI;
import com.example.lab2.data.data_source.OnboardListsLocalDataSource;
import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.data.models.PlaceholderPost;
import com.example.lab2.data.protocols.OnboardProtocol;

import java.util.List;

import retrofit2.Call;
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
    public Call<PlaceholderPost> getPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.getPost();
        return call;
    }

    @Override
    public Call<PlaceholderPost> pushPost(PlaceholderPost post) {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.pushPost(post);
        return call;
    }

    @Override
    public Call<List<PlaceholderPost>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<List<PlaceholderPost>> call = typeCodeAPI.getAllPosts();
        return call;
    }
}
