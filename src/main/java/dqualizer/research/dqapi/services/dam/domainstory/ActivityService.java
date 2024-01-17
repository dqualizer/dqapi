package dqualizer.research.dqapi.services.dam.domainstory;

import dqualizer.research.dqapi.exceptions.NotFoundException;
import dqualizer.research.dqapi.repositories.dam.domainstory.ActivityRepository;
import io.github.dqualizer.dqlang.types.dam.domainstory.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    
    @Autowired
    private ActivityRepository repository;


    public List<Activity> readAll() {
        return repository.findAll();
    }

    public Activity readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Activity with id: " + id + "."));
    }

    public Activity create(Activity entity) {
        return null; //TODO
    }
}
