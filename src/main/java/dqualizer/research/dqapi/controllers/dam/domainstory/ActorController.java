package dqualizer.research.dqapi.controllers.dam.domainstory;

import dqualizer.research.dqapi.services.dam.domainstory.ActorService;
import io.github.dqualizer.dqlang.types.dam.domainstory.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/dam/domain-story/actor")
public class ActorController {
    @Autowired
    private ActorService service;

    @GetMapping
    public ResponseEntity<List<Actor>> getAll() {
        List<Actor> actors = service.readAll();
        return new ResponseEntity<>(actors, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getById(@PathVariable String id) {
        Actor actor = service.readById(id);
        return new ResponseEntity<>(actor, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Actor> create(@RequestBody Actor entity) {
        Actor actor = service.create(entity);
        return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }
}
