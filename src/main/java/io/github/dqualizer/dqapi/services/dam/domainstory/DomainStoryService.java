package io.github.dqualizer.dqapi.services.dam.domainstory;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.dam.domainstory.DomainStoryRepository;
import io.github.dqualizer.dqlang.types.dam.domainstory.DomainStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainStoryService {
    @Autowired
    private DomainStoryRepository repository;

    public List<DomainStory> readAll() {
        return repository.findAll();
    }

    public DomainStory readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find DomainStory with id: " + id + "."));
    }

    public DomainStory create(DomainStory entity) {
        return null; //TODO
    }
}
