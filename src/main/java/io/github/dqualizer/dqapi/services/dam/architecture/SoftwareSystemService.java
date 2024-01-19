package io.github.dqualizer.dqapi.services.dam.architecture;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.dam.architecture.SoftwareSystemRepository;
import io.github.dqualizer.dqlang.types.dam.architecture.SoftwareSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareSystemService {

    @Autowired
    private SoftwareSystemRepository repository;

    public List<SoftwareSystem> readAll() {
        return repository.findAll();
    }

    public SoftwareSystem readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find SoftwareSystem with id: " + id + "."));
    }

    public SoftwareSystem create(SoftwareSystem entity) {
        return null; //TODO
    }
}
