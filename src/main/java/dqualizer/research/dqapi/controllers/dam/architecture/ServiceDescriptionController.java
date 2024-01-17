package dqualizer.research.dqapi.controllers.dam.architecture;

import dqualizer.research.dqapi.services.dam.architecture.ServiceDescriptionService;
import io.github.dqualizer.dqlang.types.dam.architecture.ServiceDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/dam/architecture/service-description")
public class ServiceDescriptionController {

    @Autowired
    private ServiceDescriptionService service;

    @GetMapping
    public ResponseEntity<List<ServiceDescription>> getAll() {
        List<ServiceDescription> serviceDescriptions = service.readAll();
        return new ResponseEntity<>(serviceDescriptions, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDescription> getById(@PathVariable String id) {
        ServiceDescription serviceDescription = service.readById(id);
        return new ResponseEntity<>(serviceDescription, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<ServiceDescription> create(@RequestBody ServiceDescription entity) {
        ServiceDescription serviceDescription = service.create(entity);
        return new ResponseEntity<>(serviceDescription, HttpStatus.CREATED);
    }

}
