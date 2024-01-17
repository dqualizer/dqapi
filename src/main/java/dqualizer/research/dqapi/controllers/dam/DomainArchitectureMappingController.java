package dqualizer.research.dqapi.controllers.dam;

import dqualizer.research.dqapi.services.dam.DomainArchitectureMappingService;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        DomainArchitectureMapping domainArchitectureMapping = service.readById(id);
        return new ResponseEntity<>(domainArchitectureMapping, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<DomainArchitectureMapping> create(@RequestBody DomainArchitectureMapping entity) {
        DomainArchitectureMapping domainArchitectureMapping = service.create(entity);
        return new ResponseEntity<>(domainArchitectureMapping, HttpStatus.CREATED);
    }



}
