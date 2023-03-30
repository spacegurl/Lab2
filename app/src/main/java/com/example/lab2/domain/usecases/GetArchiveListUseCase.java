package com.example.lab2.domain.usecases;

import com.example.lab2.domain.OnboardRepository;
import com.example.lab2.domain.entity.ArchiveListItem;

import java.util.List;

public class GetArchiveListUseCase {

    private final OnboardRepository repository;

    public GetArchiveListUseCase(OnboardRepository repository) {
        this.repository = repository;
    }

    public List<ArchiveListItem> getArchiveList(){
        return repository.getArchiveList();
    }
}
