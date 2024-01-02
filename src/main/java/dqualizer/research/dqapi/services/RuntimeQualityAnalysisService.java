package dqualizer.research.dqapi.services;

import dqualizer.research.dqapi.dtos.CreateLoadtestDto;
import dqualizer.research.dqapi.dtos.CreateResilienceTestDto;
import dqualizer.research.dqapi.dtos.CreateRqaDefinitionDto;
import dqualizer.research.dqapi.repositories.RqaDefinitionRepository;
import io.github.dqualizer.dqlang.types.dam.PathVariable;
import io.github.dqualizer.dqlang.types.dam.Payload;
import io.github.dqualizer.dqlang.types.dam.Scenario;
import io.github.dqualizer.dqlang.types.rqa.definition.Artifact;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysis;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition;
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.LoadTestDefinition;
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.Parametrization;

import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.ResponseMeasures;
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.stimulus.LoadStimulus;
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.stimulus.StimulusFactory;
import io.github.dqualizer.dqlang.types.rqa.definition.resiliencetest.ResilienceResponseMeasures;
import io.github.dqualizer.dqlang.types.rqa.definition.resiliencetest.ResilienceTestDefinition;
import io.github.dqualizer.dqlang.types.rqa.definition.resiliencetest.stimulus.ResilienceStimulus;
import io.github.dqualizer.dqlang.types.rqa.definition.resiliencetest.stimulus.UnavailabilityStimulus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class RuntimeQualityAnalysisService {
    private final RqaDefinitionRepository rqaDefinitionRepository;

    public List<RuntimeQualityAnalysisDefinition> getAllRqaDefinitions() {return rqaDefinitionRepository.findAll();}

    public RuntimeQualityAnalysisDefinition createRqaDefinition(CreateRqaDefinitionDto createRqaDefinitionDto) {
        RuntimeQualityAnalysisDefinition rqaDefinition = new RuntimeQualityAnalysisDefinition(
                createRqaDefinitionDto.getName(),
                "1",
                createRqaDefinitionDto.getEnvironment(),
                createRqaDefinitionDto.getDomainId(),
                   createRqaDefinitionDto.getContext(),
                new RuntimeQualityAnalysis());

        rqaDefinitionRepository.insert(rqaDefinition);
        return rqaDefinition;

    }

    public RuntimeQualityAnalysisDefinition insertLoadtestIntoRqa(CreateLoadtestDto loadtestDto, String rqaDefinitionId) {
        Artifact artifact = new Artifact(loadtestDto.getSystem(), loadtestDto.getActivity());
        LoadStimulus stimulus = StimulusFactory.createStimulus(loadtestDto.getLoadProfile().toString(), loadtestDto.getDesignParameters(), loadtestDto.getAccuracy());
        stimulus.setType(loadtestDto.getLoadProfile().toString());
        // Frontend doesn´t handle Parametrization yet, so we just use hardcoded parametrization
        Parametrization parametrization = new Parametrization();
        Set<PathVariable> pathVariables = new HashSet<>();

        Scenario pathVariablesScenario = new Scenario();
        pathVariablesScenario.setName("valid");
        pathVariablesScenario.setPath("auftrag/auftragsnummern/angelegt.json");
        PathVariable pathVariable = new PathVariable();
        pathVariable.setName("auftragsnummer");
        pathVariable.scenarios = new ArrayList<>();
        pathVariable.scenarios.add(pathVariablesScenario);
        parametrization.setPathVariables(pathVariables);
        parametrization.setPayload(new Payload());
        parametrization.setRequestParameter(new HashSet<>());
        parametrization.setUrlParameters(new HashSet<>());
        ResponseMeasures responseMeasures = new ResponseMeasures(loadtestDto.getResponseTime());
        LoadTestDefinition loadtest = new LoadTestDefinition(loadtestDto.getName(), artifact,"No description", stimulus,parametrization,responseMeasures, loadtestDto.getResultMetrics());

        return rqaDefinitionRepository.findById(rqaDefinitionId).map(rqaDefinition -> {

            rqaDefinition.getRuntimeQualityAnalysis().getLoadtests().add(loadtest);
            rqaDefinitionRepository.save(rqaDefinition);
            return rqaDefinition;
        }).orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));
    }

    public RuntimeQualityAnalysisDefinition insertResilienceTestIntoRqa(CreateResilienceTestDto resilienceTestDto, String rqaDefinitionId) {
        Artifact artifact = new Artifact(resilienceTestDto.getSystem(), null);
        ResilienceStimulus stimulus = new UnavailabilityStimulus(resilienceTestDto.getStimulusType(), resilienceTestDto.getAccuracy());


        ResilienceResponseMeasures responseMeasures = new ResilienceResponseMeasures(resilienceTestDto.getRecoveryTime());
        ResilienceTestDefinition resilienceTest = new ResilienceTestDefinition(resilienceTestDto.getName(), artifact,"No description", stimulus, responseMeasures);

        return rqaDefinitionRepository.findById(rqaDefinitionId).map(rqaDefinition -> {

            rqaDefinition.getRuntimeQualityAnalysis().getResilienceTests().add(resilienceTest);
            rqaDefinitionRepository.save(rqaDefinition);
            return rqaDefinition;
        }).orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));
    }

    public List<RuntimeQualityAnalysisDefinition> deleteRqaDefinitionById(String id) {
        rqaDefinitionRepository.deleteById(id);
        return rqaDefinitionRepository.findAll();
    }


    public RuntimeQualityAnalysisDefinition deleteLoadtestFromRqaDefinition(String rqaDefinitionId, String loadtestName) {
        RuntimeQualityAnalysisDefinition rqaDefinition = rqaDefinitionRepository.findById(rqaDefinitionId)
                .orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));

        RuntimeQualityAnalysis runtimeQualityAnalysis = rqaDefinition.getRuntimeQualityAnalysis();

        // Get the list of loadtests from the runtimeQualityAnalysis
        Set<LoadTestDefinition> loadtests = runtimeQualityAnalysis.getLoadtests();

        // Find the loadtest to be removed
        LoadTestDefinition loadtestToRemove = null;
        for (LoadTestDefinition loadtest : loadtests) {
            if (loadtest.getName().equals(loadtestName)) {
                loadtestToRemove = loadtest;
                break;
            }
        }

        // Remove the loadtest if found
        if (loadtestToRemove != null) {
            loadtests.remove(loadtestToRemove);
        } else {
            throw new IllegalStateException("No Loadtest with name \"" + loadtestName + "\" found in RQA Definition.");
        }

        // Save the updated RqaDefinition back to the repository
        rqaDefinitionRepository.save(rqaDefinition);

        return rqaDefinition;
    }

    public List<RuntimeQualityAnalysisDefinition> deleteAllRqaDefinitions() {
        rqaDefinitionRepository.deleteAll();
        return rqaDefinitionRepository.findAll();
    }

    public RuntimeQualityAnalysisDefinition getRqaDefinitionByNameOrId(String name) {

        return rqaDefinitionRepository.findByNameOrId(name,name).orElseThrow(() -> new IllegalStateException("No RQA Definition with name " + name + " found."));
    }

    public RuntimeQualityAnalysisDefinition deleteAllLoadtestsFromRqa(String rqaDefinitionId) {
        RuntimeQualityAnalysisDefinition rqaDefinition = rqaDefinitionRepository.findById(rqaDefinitionId)
                .orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));

        RuntimeQualityAnalysis runtimeQualityAnalysis = rqaDefinition.getRuntimeQualityAnalysis();
        runtimeQualityAnalysis.setLoadtests(new HashSet<>());

        return rqaDefinition;
    }

    public RuntimeQualityAnalysisDefinition deleteAllResilienceTestsFromRqa(String rqaDefinitionId) {
        RuntimeQualityAnalysisDefinition rqaDefinition = rqaDefinitionRepository.findById(rqaDefinitionId)
                .orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));

        RuntimeQualityAnalysis runtimeQualityAnalysis = rqaDefinition.getRuntimeQualityAnalysis();
        runtimeQualityAnalysis.setResilienceTests(new HashSet<>());

        return rqaDefinition;
    }

    public RuntimeQualityAnalysisDefinition deleteResilienceTestFromRqaDefinition(String rqaDefinitionId, String resilienceTestName) {

        RuntimeQualityAnalysisDefinition rqaDefinition = rqaDefinitionRepository.findById(rqaDefinitionId)
                .orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));

        RuntimeQualityAnalysis runtimeQualityAnalysis = rqaDefinition.getRuntimeQualityAnalysis();

        // Get the list of resilienceTestDefinitions from the runtimeQualityAnalysis
        Set<ResilienceTestDefinition> resilienceTestDefinitions = runtimeQualityAnalysis.getResilienceTests();

        // Find the loadtest to be removed
        ResilienceTestDefinition resilienceTestToRemove = null;
        for (ResilienceTestDefinition resilienceTestDefinition : resilienceTestDefinitions) {
            if (resilienceTestDefinition.getName().equals(resilienceTestName)) {
                resilienceTestToRemove = resilienceTestDefinition;
                break;
            }
        }

        // Remove the loadtest if found
        if (resilienceTestToRemove != null) {
            resilienceTestDefinitions.remove(resilienceTestToRemove);
        } else {
            throw new IllegalStateException("No ResilienceTest with name \"" + resilienceTestName + "\" found in RQA Definition.");
        }

        // Save the updated RqaDefinition back to the repository
        rqaDefinitionRepository.save(rqaDefinition);

        return rqaDefinition;
    }
}
