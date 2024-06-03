package io.github.dqualizer.dqapi.controllers.dam;

import io.github.dqualizer.dqapi.services.dam.DomainArchitectureMappingService;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {}


@RestController
@RequestMapping("/api/v2/dam")
public class DomainArchitectureMappingController {

    @Autowired
    private DomainArchitectureMappingService service;

    @GetMapping
    public ResponseEntity<List<DomainArchitectureMapping>> getAll() {
        List<DomainArchitectureMapping> domainArchitectureMappings = service.readAll();
        return new ResponseEntity<>(domainArchitectureMappings, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainArchitectureMapping> getById(@PathVariable String id) {
        System.out.println("The id is "+ id);

        if (id.equals("add")) {
            DomainArchitectureMapping domainArchitectureMapping = service.loadDAM();
            service.create(domainArchitectureMapping);
            return new ResponseEntity<>(domainArchitectureMapping, HttpStatus.FOUND);
        }

        DomainArchitectureMapping domainArchitectureMapping = service.readById(id);
        return new ResponseEntity<>(domainArchitectureMapping, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<DomainArchitectureMapping> create(@RequestBody DomainArchitectureMapping entity) {
        DomainArchitectureMapping domainArchitectureMapping = service.create(entity);
        return new ResponseEntity<>(domainArchitectureMapping, HttpStatus.CREATED);
    }
}