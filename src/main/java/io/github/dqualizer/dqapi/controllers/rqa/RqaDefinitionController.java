package io.github.dqualizer.dqapi.controllers.rqa;

import io.github.dqualizer.dqapi.services.rqa.RqaDefinitionService;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition;
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.LoadTestDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api/v2/rqa")
public class RqaDefinitionController {

    @Autowired
    private RqaDefinitionService service;

    @GetMapping
    public ResponseEntity<List<RuntimeQualityAnalysisDefinition>> getAllRqaDefinitions() {
        List<RuntimeQualityAnalysisDefinition> runtimeQualityAnalysisDefinitions = service.readAll();
        return new ResponseEntity<>(runtimeQualityAnalysisDefinitions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RuntimeQualityAnalysisDefinition> getRqaDefinitionById(@PathVariable String id){
        RuntimeQualityAnalysisDefinition rqaDefinition = service.readById(id);
        return new ResponseEntity<>(rqaDefinition, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<RuntimeQualityAnalysisDefinition> createRqaDefinition(@RequestBody RuntimeQualityAnalysisDefinition entity) {
        RuntimeQualityAnalysisDefinition runtimeQualityAnalysisDefinition = service.create(entity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(runtimeQualityAnalysisDefinition.getId())
                .toUri();

        return ResponseEntity.created(location).body(runtimeQualityAnalysisDefinition);
    }

    @PostMapping("/{rqaId}/loadtest")
    public ResponseEntity<RuntimeQualityAnalysisDefinition> createLoadtest(@PathVariable String rqaId, @RequestBody LoadTestDefinition entity) {

        RuntimeQualityAnalysisDefinition rqa = service.createLoadtest(rqaId, entity);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(rqaId + "/loadtest/{id}")
                .buildAndExpand(rqa.getId())
                .toUri();

        return ResponseEntity.created(location).body(rqa);
    }
}
