package io.github.dqualizer.dqapi.services.dam.architecture;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.dam.architecture.ServiceDescriptionRepository;
import io.github.dqualizer.dqlang.types.dam.architecture.ServiceDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDescriptionService {

    @Autowired
    private ServiceDescriptionRepository repository;

    public List<ServiceDescription> readAll() {
        return repository.findAll();
    }

    public ServiceDescription readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Service-Description with id: " + id + "."));
    }

    public ServiceDescription create(ServiceDescription entity) {
        return null; //TODOd
    }
}
