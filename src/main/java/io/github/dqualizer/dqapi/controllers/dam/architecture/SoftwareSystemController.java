package io.github.dqualizer.dqapi.controllers.dam.architecture;

import io.github.dqualizer.dqapi.services.dam.architecture.SoftwareSystemService;
import io.github.dqualizer.dqlang.types.dam.architecture.SoftwareSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/dam/architecture/software-system")
public class SoftwareSystemController {

    @Autowired
    private SoftwareSystemService service;

    @GetMapping
    public ResponseEntity<List<SoftwareSystem>> getAll() {
        List<SoftwareSystem> softwareSystems = service.readAll();
        return new ResponseEntity<>(softwareSystems, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoftwareSystem> getById(@PathVariable String id) {
        SoftwareSystem softwareSystem = service.readById(id);
        return new ResponseEntity<>(softwareSystem, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<SoftwareSystem> create(@RequestBody SoftwareSystem entity) {
        SoftwareSystem softwareSystem = service.create(entity);
        return new ResponseEntity<>(softwareSystem, HttpStatus.CREATED);
    }

}
