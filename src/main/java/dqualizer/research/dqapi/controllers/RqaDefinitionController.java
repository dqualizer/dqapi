package dqualizer.research.dqapi.controllers;

import dqualizer.research.dqapi.dtos.CreateLoadtestDto;
import dqualizer.research.dqapi.dtos.CreateRqaDefinitionDto;
import dqualizer.research.dqapi.models.rqa.RqaDefinition;
import dqualizer.research.dqapi.services.RuntimeQualityAnalysisService;
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
    public ResponseEntity<List<RqaDefinition>> readAllRqaDefinitions() {
        return  new ResponseEntity<>(runtimeQualityAnalysisService.getAllRqaDefinitions(), HttpStatus.OK);
    }

    @GetMapping("/{rqaName}")
    public ResponseEntity<RqaDefinition> getRqaDefinitionByName(@PathVariable String rqaName) {
        return new ResponseEntity<>(runtimeQualityAnalysisService.getRqaDefinitionByNameOrId(rqaName), HttpStatus.OK);
    }

    @PostMapping
    public RqaDefinition createRqaDefinition(@RequestBody CreateRqaDefinitionDto createRqaDefinitionDto) {
        return runtimeQualityAnalysisService.createRqaDefinition(createRqaDefinitionDto);
    }

    @DeleteMapping("/{id}")
    public List<RqaDefinition> deleteRqaDefinitionById(@PathVariable String id) {
        return runtimeQualityAnalysisService.deleteRqaDefinitionById(id);
    }

    @DeleteMapping
    public List<RqaDefinition> deleteAllRqaDefinitions() {
        return runtimeQualityAnalysisService.deleteAllRqaDefinitions();
    }

    @PutMapping("/{rqaDefinitionId}/loadtest")
    public RqaDefinition insertLoadtestToRqa(@RequestBody CreateLoadtestDto createLoadtestDto, @PathVariable String rqaDefinitionId) {
        return runtimeQualityAnalysisService.insertLoadtestToRqa(createLoadtestDto, rqaDefinitionId);
    }

    @DeleteMapping("/{rqaDefinitionId}/loadtest/{loadtestName}")
    public RqaDefinition deleteLoadtestFromRqa(@PathVariable String rqaDefinitionId, @PathVariable String loadtestName) {
        return  runtimeQualityAnalysisService.deleteLoadtestFromRqaDefinition(rqaDefinitionId, loadtestName);
    }

    @DeleteMapping("/{rqaDefinitionId}/loadtest")
    public ResponseEntity<List<RqaDefinition>> deleteAllLoadtestsFromRqa(@PathVariable String rqaDefinitionId) {
        return new ResponseEntity(runtimeQualityAnalysisService.deleteAllLoadtestsFromRqa(rqaDefinitionId), HttpStatus.OK);
    }
}
