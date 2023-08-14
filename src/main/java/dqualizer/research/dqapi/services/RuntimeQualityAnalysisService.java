package dqualizer.research.dqapi.services;

import dqualizer.research.dqapi.dtos.CreateLoadtestDto;
import dqualizer.research.dqapi.dtos.CreateRqaDefinitionDto;
import dqualizer.research.dqapi.models.rqa.loadtest.stimulus.StimulusFactory;
import dqualizer.research.dqapi.repositories.RqaDefinitionRepository;
import dqualizer.research.dqapi.models.rqa.RqaDefinition;
import dqualizer.research.dqapi.models.rqa.RuntimeQualityAnalysis;
import dqualizer.research.dqapi.models.rqa.loadtest.Artifact;
import dqualizer.research.dqapi.models.rqa.loadtest.Loadtest;
import dqualizer.research.dqapi.models.rqa.loadtest.parametrization.Parametrization;
import dqualizer.research.dqapi.models.rqa.loadtest.parametrization.ResponseMeasures;
import dqualizer.research.dqapi.models.rqa.loadtest.stimulus.Stimulus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RuntimeQualityAnalysisService {
    private final RqaDefinitionRepository rqaDefinitionRepository;

    public List<RqaDefinition> getAllRqaDefinitions() {return rqaDefinitionRepository.findAll();}
    public RqaDefinition createRqaDefinition(CreateRqaDefinitionDto createRqaDefinitionDto) {
        RqaDefinition rqaDefinition = new RqaDefinition(createRqaDefinitionDto.getName(), "1", createRqaDefinitionDto.getEnvironment(), createRqaDefinitionDto.getDomainId(), new RuntimeQualityAnalysis());
        rqaDefinitionRepository.insert(rqaDefinition);
        return rqaDefinition;

    }

    public RqaDefinition insertLoadtestToRqa(CreateLoadtestDto loadtestDto, String rqaDefinitionId) {
        Artifact artifact = new Artifact(loadtestDto.getSystem(), loadtestDto.getActivity());
        Stimulus stimulus = StimulusFactory.createStimulus(loadtestDto.getLoadProfile().toString(), loadtestDto.getDesignParameters(), loadtestDto.getAccuracy());
        // Frontend doesn´t handle Parametrization yet, so we just use hardcoded parametrization
        Parametrization parametrization = new Parametrization();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("auftragsnummer", "auftrag/auftragsnummern/angelegt.json");
        parametrization.setPathVariables(parameters);
        ResponseMeasures responseMeasures = new ResponseMeasures(loadtestDto.getResponseTime());
        Loadtest loadtest = new Loadtest(loadtestDto.getName(), artifact,"No description", stimulus,parametrization,responseMeasures, loadtestDto.getResultMetrics());

        return rqaDefinitionRepository.findById(rqaDefinitionId).map(rqaDefinition -> {

            rqaDefinition.getRuntimeQualityAnalysis().getLoadtests().add(loadtest);
            rqaDefinitionRepository.save(rqaDefinition);
            return rqaDefinition;
        }).orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));
    }

    public List<RqaDefinition> deleteRqaDefinitionById(String id) {
        rqaDefinitionRepository.deleteById(id);
        return rqaDefinitionRepository.findAll();
    }


    public RqaDefinition deleteLoadtestFromRqaDefinition(String rqaDefinitionId, String loadtestName) {
        RqaDefinition rqaDefinition = rqaDefinitionRepository.findById(rqaDefinitionId)
                .orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));

        RuntimeQualityAnalysis runtimeQualityAnalysis = rqaDefinition.getRuntimeQualityAnalysis();

        // Get the list of loadtests from the runtimeQualityAnalysis
        List<Loadtest> loadtests = runtimeQualityAnalysis.getLoadtests();

        // Find the loadtest to be removed
        Loadtest loadtestToRemove = null;
        for (Loadtest loadtest : loadtests) {
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

    public List<RqaDefinition> deleteAllRqaDefinitions() {
        rqaDefinitionRepository.deleteAll();
        return rqaDefinitionRepository.findAll();
    }

    public RqaDefinition getRqaDefinitionByName(String name) {
        return rqaDefinitionRepository.findByName(name).orElseThrow(() -> new IllegalStateException("No RQA Definition with name " + name + " found."));
    }

    public RqaDefinition deleteAllLoadtestsFromRqa(String rqaDefinitionId) {
        RqaDefinition rqaDefinition = rqaDefinitionRepository.findById(rqaDefinitionId)
                .orElseThrow(() -> new IllegalStateException("No RQA Definition with id \"" + rqaDefinitionId + "\" found."));

        RuntimeQualityAnalysis runtimeQualityAnalysis = rqaDefinition.getRuntimeQualityAnalysis();
        runtimeQualityAnalysis.setLoadtests(new ArrayList<Loadtest>());

        return rqaDefinition;
    }
}
