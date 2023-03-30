package com.example.lab2.domain.usecases;

import com.example.lab2.domain.OnboardRepository;
import com.example.lab2.domain.entity.ProjectListItem;

public class AddProjectItemUseCase {

    private final OnboardRepository repository;

    public AddProjectItemUseCase(OnboardRepository repository) {
        this.repository = repository;
    }

    public void addProjectItem(ProjectListItem projectListItem){
        repository.addProjectItem(projectListItem);
    }
}
