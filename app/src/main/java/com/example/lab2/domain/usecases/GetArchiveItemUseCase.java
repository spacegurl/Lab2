package com.example.lab2.domain.usecases;

import com.example.lab2.domain.OnboardRepository;
import com.example.lab2.domain.entity.ArchiveListItem;

public class GetArchiveItemUseCase {

    private final OnboardRepository repository;

    public GetArchiveItemUseCase(OnboardRepository repository) {
        this.repository = repository;
    }

    public ArchiveListItem getArchiveItem(int position){
        return repository.getArchiveItem(position);
    }
}
