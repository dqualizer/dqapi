package io.github.dqualizer.dqapi.controllers.dam.mapping;

import io.github.dqualizer.dqapi.services.dam.mapping.DAMappingService;
import io.github.dqualizer.dqlang.types.dam.domainstory.Activity;
import io.github.dqualizer.dqlang.types.dam.mapping.DAMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/dam/da-mapping")
public class DAMappingController {
    @Autowired
    private DAMappingService service;

    @GetMapping
    public ResponseEntity<List<DAMapping>> getAll() {
        List<DAMapping> daMapping = service.readAll();
        return new ResponseEntity<>(daMapping, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DAMapping> getById(@PathVariable String id) {
        DAMapping daMapping = service.readById(id);
        return new ResponseEntity<>(daMapping, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Activity> create(@RequestBody Activity entity) {
        Activity activity = service.create(entity);
        return new ResponseEntity<>(activity, HttpStatus.CREATED);
    }

}
