package dqualizer.research.dqapi.controllers.dam;

import dqualizer.research.dqapi.services.dam.DomainArchitectureMappingService;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.Set;

@RestController
@RequestMapping("/api/v2/dam")
public class DomainArchitectureMappingController {

    @Autowired
    private DomainArchitectureMappingService service;

    @GetMapping
    public ResponseEntity<Set<DomainArchitectureMapping>> all() {
        Set<DomainArchitectureMapping> domainArchitectureMappings = service.
        return new ResponseEntity<>
    }

}
