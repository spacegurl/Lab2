package com.example.lab2.data.data_source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lab2.R;
import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.data.models.ProjectListItem;

import java.util.ArrayList;
import java.util.List;

public class OnboardListsLocalDataSource {

    private List<ProjectListItem> projectListItems = new ArrayList<>();
    private List<ArchiveListItem> archiveListItems = new ArrayList<>();

    public LiveData<List<ProjectListItem>> getProjectList() {
        String[] arr = {"Knightsbridge Penthouse", "London House", "Edinburgh Cottage",
                "Loch-Ness Scotland Villa", "221B Backer Street", "Clarence House", "Chanel Boutique",
                "Anna Vintour's Apartment"};
        List<ProjectListItem> list = new ArrayList<>();

        for (int i = 0; i < 250; i++) {
            projectListItems.add(new ProjectListItem(R.drawable.paint_swatches, arr[(int) (Math.random() * arr.length)]));
        }
        MutableLiveData<List<ProjectListItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(projectListItems);
        return mutableLiveData;
    }

    public LiveData<List<ArchiveListItem>> getArchiveList() {
        String[] arr = {"Cambridge Campus", "Chelsea Cottage", "Gherkin Vogue Office",
                "Oxford Campus", "Birmingham Campus", "Manchester Campus", "Bristol Campus", "Leeds Campus"};
        List<ArchiveListItem> list = new ArrayList<>();

        for (int i = 0; i < 250; i++) {
            list.add(new ArchiveListItem(R.drawable.cat_on_docs, arr[(int) (Math.random() * arr.length)]));
        }
        MutableLiveData<List<ArchiveListItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(list);
        return mutableLiveData;
    }

    public LiveData<ArchiveListItem> getArchiveItem(int position) {
        String[] arr = {"Cambridge Campus", "Chelsea Cottage", "Gherkin Vogue Office",
                "Oxford Campus", "Birmingham Campus", "Manchester Campus", "Bristol Campus", "Leeds Campus"};
        List<ArchiveListItem> list = new ArrayList<>();

        for (int i = 0; i < 250; i++) {
            list.add(new ArchiveListItem(R.drawable.cat_on_docs, arr[(int) (Math.random() * arr.length)]));
        }
        MutableLiveData<ArchiveListItem> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(list.get(position));
        return mutableLiveData;
    }

    public LiveData<ProjectListItem> getProjectItem(int position) {
        String[] arr = {"Cambridge Campus", "Chelsea Cottage", "Gherkin Vogue Office",
                "Oxford Campus", "Birmingham Campus", "Manchester Campus", "Bristol Campus", "Leeds Campus"};
        List<ProjectListItem> list = new ArrayList<>();

        for (int i = 0; i < 250; i++) {
            list.add(new ProjectListItem(R.drawable.cat_on_docs, arr[(int) (Math.random() * arr.length)]));
        }
        MutableLiveData<ProjectListItem> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(list.get(position));
        return mutableLiveData;
    }

    public void addProjectItem(ProjectListItem item) {
        projectListItems.add(item);
    }

    public void addArchiveItem(ArchiveListItem item) {
        archiveListItems.add(item);
    }
}
