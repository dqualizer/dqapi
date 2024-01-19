package io.github.dqualizer.dqapi.controllers.dam.domainstory;

import io.github.dqualizer.dqapi.services.dam.domainstory.DomainStoryService;
import io.github.dqualizer.dqlang.types.dam.domainstory.DomainStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/dam/domain-story")
public class DomainStoryController {

    @Autowired
    private DomainStoryService service;

    @GetMapping
    public ResponseEntity<List<DomainStory>> getAll() {
        List<DomainStory> domainStories = service.readAll();
        return new ResponseEntity<>(domainStories, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainStory> getById(@PathVariable String id) {
        DomainStory domainStory = service.readById(id);
        return new ResponseEntity<>(domainStory, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<DomainStory> create(@RequestBody DomainStory entity) {
        DomainStory domainStory = service.create(entity);
        return new ResponseEntity<>(domainStory, HttpStatus.CREATED);
    }
}
