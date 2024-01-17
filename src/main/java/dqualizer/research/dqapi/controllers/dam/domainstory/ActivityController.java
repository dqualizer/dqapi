package dqualizer.research.dqapi.controllers.dam.domainstory;

import dqualizer.research.dqapi.services.dam.domainstory.ActivityService;
import io.github.dqualizer.dqlang.types.dam.domainstory.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/dam/domain-story/activity")
public class ActivityController {

    @Autowired
    private ActivityService service;

    @GetMapping
    public ResponseEntity<List<Activity>> getAll() {
        List<Activity> activities = service.readAll();
        return new ResponseEntity<>(activities, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getById(@PathVariable String id) {
        Activity activity = service.readById(id);
        return new ResponseEntity<>(activity, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Activity> create(@RequestBody Activity entity) {
        Activity activity = service.create(entity);
        return new ResponseEntity<>(activity, HttpStatus.CREATED);
    }

}
