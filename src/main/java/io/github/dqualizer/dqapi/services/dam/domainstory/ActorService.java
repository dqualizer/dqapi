package io.github.dqualizer.dqapi.services.dam.domainstory;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.dam.domainstory.ActorRepository;
import io.github.dqualizer.dqlang.types.dam.domainstory.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository repository;

    public List<Actor> readAll() {
        return repository.findAll();
    }

    public Actor readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Actor with id: " + id + "."));
    }

    public Actor create(Actor entity) {
        return null; //TODO
    }
}
