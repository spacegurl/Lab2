package com.example.lab2.domain.usecases;

import com.example.lab2.domain.OnboardRepository;
import com.example.lab2.domain.entity.ProjectListItem;

import java.util.List;

public class GetProjectListUseCase {

    private final OnboardRepository repository;

    public GetProjectListUseCase(OnboardRepository repository) {
        this.repository = repository;
    }

    public List<ProjectListItem> getProjectList(){
        return repository.getProjectList();
    }
}
