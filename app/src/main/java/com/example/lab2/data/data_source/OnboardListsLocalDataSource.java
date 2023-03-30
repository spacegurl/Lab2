package com.example.lab2.data.data_source;

import com.example.lab2.R;
import com.example.lab2.domain.entity.ArchiveListItem;
import com.example.lab2.domain.entity.ProjectListItem;

import java.util.ArrayList;
import java.util.List;

public class OnboardListsLocalDataSource {

    private List<ProjectListItem> projectListItems = new ArrayList<>();
    private List<ArchiveListItem> archiveListItems = new ArrayList<>();
    public List<ProjectListItem> getProjectList(){
        String[] arr = {"Knightsbridge Penthouse", "London House", "Edinburgh Cottage",
                "Loch-Ness Scotland Villa", "221B Backer Street", "Clarence House", "Chanel Boutique",
                "Anna Vintour's Apartment"};
        List<ProjectListItem> list = new ArrayList<>();

        for (int i = 0; i < 250; i++){
            projectListItems.add(new ProjectListItem(R.drawable.paint_swatches, arr[(int)(Math.random() * arr.length)]));
        }
        return projectListItems;
    }

    public List<ArchiveListItem> getArchiveList(){
        String[] arr = {"Cambridge Campus", "Chelsea Cottage", "Gherkin Vogue Office",
                "Oxford Campus", "Birmingham Campus", "Manchester Campus", "Bristol Campus", "Leeds Campus"};
        List<ArchiveListItem> list = new ArrayList<>();

        for (int i = 0; i < 250; i++){
            archiveListItems.add(new ArchiveListItem(R.drawable.cat_on_docs, arr[(int)(Math.random() * arr.length)]));
        }
        return archiveListItems;
    }

    public void addProjectItem(ProjectListItem item){
        projectListItems.add(item);
    }

    public void addArchiveItem(ArchiveListItem item){
        archiveListItems.add(item);
    }
}
