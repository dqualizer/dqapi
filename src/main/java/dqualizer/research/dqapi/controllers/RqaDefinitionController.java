package dqualizer.research.dqapi.controllers;

import dqualizer.research.dqapi.dtos.CreateLoadtestDto;
import dqualizer.research.dqapi.dtos.CreateResilienceTestDto;
import dqualizer.research.dqapi.dtos.CreateRqaDefinitionDto;
import dqualizer.research.dqapi.services.RuntimeQualityAnalysisService;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/rqa-definition")
@AllArgsConstructor
public class RqaDefinitionController {
    private final RuntimeQualityAnalysisService runtimeQualityAnalysisService;

    @GetMapping
    public ResponseEntity<List<RuntimeQualityAnalysisDefinition>> readAllRqaDefinitions() {
        return  new ResponseEntity<>(runtimeQualityAnalysisService.getAllRqaDefinitions(), HttpStatus.OK);
    }

    @GetMapping("/{rqaName}")
    public ResponseEntity<RuntimeQualityAnalysisDefinition> getRqaDefinitionByName(@PathVariable String rqaName) {
        return new ResponseEntity<>(runtimeQualityAnalysisService.getRqaDefinitionByNameOrId(rqaName), HttpStatus.OK);
    }

    @PostMapping
    public RuntimeQualityAnalysisDefinition createRqaDefinition(@RequestBody CreateRqaDefinitionDto createRqaDefinitionDto) {
        return runtimeQualityAnalysisService.createRqaDefinition(createRqaDefinitionDto);
    }

    @DeleteMapping("/{id}")
    public List<RuntimeQualityAnalysisDefinition> deleteRqaDefinitionById(@PathVariable String id) {
        return runtimeQualityAnalysisService.deleteRqaDefinitionById(id);
    }

    @DeleteMapping
    public List<RuntimeQualityAnalysisDefinition> deleteAllRqaDefinitions() {
        return runtimeQualityAnalysisService.deleteAllRqaDefinitions();
    }

    @PutMapping("/{rqaDefinitionId}/loadtest")
    public RuntimeQualityAnalysisDefinition insertLoadtestIntoRqa(@RequestBody CreateLoadtestDto createLoadtestDto, @PathVariable String rqaDefinitionId) {
        return runtimeQualityAnalysisService.insertLoadtestIntoRqa(createLoadtestDto, rqaDefinitionId);
    }

    @PutMapping("/{rqaDefinitionId}/resilienceTest")
    public RuntimeQualityAnalysisDefinition insertResilienceTestIntoRqa(@RequestBody CreateResilienceTestDto createResilienceTestDto, @PathVariable String rqaDefinitionId) {
        return runtimeQualityAnalysisService.insertResilienceTestIntoRqa(createResilienceTestDto, rqaDefinitionId);
    }

    @DeleteMapping("/{rqaDefinitionId}/loadtest/{loadtestName}")
    public RuntimeQualityAnalysisDefinition deleteLoadtestFromRqa(@PathVariable String rqaDefinitionId, @PathVariable String loadtestName) {
        return  runtimeQualityAnalysisService.deleteLoadtestFromRqaDefinition(rqaDefinitionId, loadtestName);
    }

    @DeleteMapping("/{rqaDefinitionId}/loadtest")
    public ResponseEntity<List<RuntimeQualityAnalysisDefinition>> deleteAllLoadtestsFromRqa(@PathVariable String rqaDefinitionId) {
        return new ResponseEntity(runtimeQualityAnalysisService.deleteAllLoadtestsFromRqa(rqaDefinitionId), HttpStatus.OK);
    }

    @DeleteMapping("/{rqaDefinitionId}/resilienceTests")
    public ResponseEntity<List<RuntimeQualityAnalysisDefinition>> deleteAllResilienceTestsFromRqa(@PathVariable String rqaDefinitionId) {
        return new ResponseEntity(runtimeQualityAnalysisService.deleteAllResilienceTestsFromRqa(rqaDefinitionId), HttpStatus.OK);
    }

    @DeleteMapping("/{rqaDefinitionId}/resilienceTest/{resilienceTestName}")
    public RuntimeQualityAnalysisDefinition deleteResilienceTestFromRqa(@PathVariable String rqaDefinitionId, @PathVariable String resilienceTestName) {
        return  runtimeQualityAnalysisService.deleteResilienceTestFromRqaDefinition(rqaDefinitionId, resilienceTestName);
    }
}
