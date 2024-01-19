package io.github.dqualizer.dqapi.services.dam.domainstory;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.dam.domainstory.WorkObjectRepository;
import io.github.dqualizer.dqlang.types.dam.domainstory.WorkObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkObjectService {
    @Autowired
    private WorkObjectRepository repository;

    public List<WorkObject> readAll() {
        return repository.findAll();
    }

    public WorkObject readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find WorkObject with id: " + id + "."));
    }

    public WorkObject create(WorkObject entity) {
        return null; //TODO
    }


}
