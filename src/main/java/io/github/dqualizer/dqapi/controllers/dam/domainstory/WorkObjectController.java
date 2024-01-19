package io.github.dqualizer.dqapi.controllers.dam.domainstory;

import io.github.dqualizer.dqapi.services.dam.domainstory.WorkObjectService;
import io.github.dqualizer.dqlang.types.dam.domainstory.WorkObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/dam/domain-story/work-object")
public class WorkObjectController {

    @Autowired
    private WorkObjectService service;

    @GetMapping
    public ResponseEntity<List<WorkObject>> getAll() {
        List<WorkObject> workObjects = service.readAll();
        return new ResponseEntity<>(workObjects, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkObject> getById(@PathVariable String id) {
        WorkObject workObject = service.readById(id);
        return new ResponseEntity<>(workObject, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<WorkObject> create(@RequestBody WorkObject entity) {
        WorkObject workObject = service.create(entity);
        return new ResponseEntity<>(workObject, HttpStatus.CREATED);
    }
}
