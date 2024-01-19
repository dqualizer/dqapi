package io.github.dqualizer.dqapi.controllers.rqa;

import io.github.dqualizer.dqapi.services.rqa.RqaDefinitionService;
import io.github.dqualizer.dqlang.types.dam.domainstory.WorkObject;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysis;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/rqa")
public class RqaDefinitionController {

    @Autowired
    private RqaDefinitionService service;

    @GetMapping
    public ResponseEntity<List<RuntimeQualityAnalysisDefinition>> getAll() {
        List<RuntimeQualityAnalysisDefinition> runtimeQualityAnalysisDefinitions = service.readAll();
        return new ResponseEntity<>(runtimeQualityAnalysisDefinitions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RuntimeQualityAnalysisDefinition> getById(@PathVariable String id){
        RuntimeQualityAnalysisDefinition rqaDefinition = service.readById(id);
        return new ResponseEntity<>(rqaDefinition, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<RuntimeQualityAnalysisDefinition> create(@RequestBody RuntimeQualityAnalysisDefinition entity) {
        RuntimeQualityAnalysisDefinition runtimeQualityAnalysisDefinition = service.create(entity);
        return new ResponseEntity<>(runtimeQualityAnalysisDefinition, HttpStatus.CREATED);
    }
}
