package io.github.dqualizer.dqapi.services.rqa;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.rqa.RqaDefinitionRepository;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysis;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RqaDefinitionService {

    @Autowired
    private RqaDefinitionRepository repository;

    public List<RuntimeQualityAnalysisDefinition> readAll() {
        return repository.findAll();
    }

    public RuntimeQualityAnalysisDefinition readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Runtime Quality Analysis Definition with id: "  + id + "."));
    }

    public RuntimeQualityAnalysisDefinition create(RuntimeQualityAnalysisDefinition entity) {
        RuntimeQualityAnalysisDefinition rqaDefinition =
                new RuntimeQualityAnalysisDefinition(
                        entity.getName(),
                        entity.getVersion(),
                        entity.getDomainId(),
                        entity.getContext(),
                        entity.getEnvironment(),
                        new RuntimeQualityAnalysis()
                );
        return repository.save(entity);
    }
}
