package io.github.dqualizer.dqapi.services.dam.mapping;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.dam.mapping.DAMappingRepository;
import io.github.dqualizer.dqlang.types.dam.domainstory.Activity;
import io.github.dqualizer.dqlang.types.dam.mapping.DAMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DAMappingService {

    @Autowired
    private DAMappingRepository repository;

    public List<DAMapping> readAll() {
        return repository.findAll();
    }

    public DAMapping readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find DA-Mapping with id: " + id + "."));
    }

    public Activity create(Activity entity) {
        return null; //TODO
    }



}
