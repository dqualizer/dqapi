package io.github.dqualizer.dqapi.services.dam;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.dam.DomainArchitectureMappingRepository;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainArchitectureMappingService {

    @Autowired
    private DomainArchitectureMappingRepository repository;

    public List<DomainArchitectureMapping> readAll() {
        return repository.findAll();
    }
    public DomainArchitectureMapping readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Domain-Architecture-Mapping with id: " + id + "."));
    }

    public DomainArchitectureMapping create(DomainArchitectureMapping entity) {
        return null; //TODO
    }
}
