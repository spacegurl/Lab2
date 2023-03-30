package com.example.lab2.domain.usecases;

import com.example.lab2.domain.OnboardRepository;
import com.example.lab2.domain.entity.ArchiveListItem;

public class AddArchiveItemUseCase {

    private final OnboardRepository repository;

    public AddArchiveItemUseCase(OnboardRepository repository) {
        this.repository = repository;
    }

    public void addArchiveItem (ArchiveListItem archiveListItem){
        repository.addArchiveItem(archiveListItem);
    }
}
