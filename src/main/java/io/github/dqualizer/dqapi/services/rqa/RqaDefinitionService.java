package io.github.dqualizer.dqapi.services.rqa;

import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.rqa.RqaDefinitionRepository;
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition;
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.LoadTestDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RqaDefinitionService {

    @Autowired
    private RqaDefinitionRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<RuntimeQualityAnalysisDefinition> readAll() {
        return repository.findAll();
    }

    public RuntimeQualityAnalysisDefinition readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Runtime Quality Analysis Definition with id: " + id + "."));
    }

    public RuntimeQualityAnalysisDefinition create(RuntimeQualityAnalysisDefinition entity) {

            RuntimeQualityAnalysisDefinition rqaDefinition =
                    new RuntimeQualityAnalysisDefinition(
                            entity.getName(),
                            entity.getVersion(),
                            entity.getDomainId(),
                            entity.getContext(),
                            entity.getEnvironment(),
                            entity.getRuntimeQualityAnalysis()
                    );
        try {
            return repository.save(entity);
        } catch(DuplicateKeyException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "RqaDefinition with the same name already exists.", e);
        }

    }

    public RuntimeQualityAnalysisDefinition createLoadtest(String id, LoadTestDefinition entity) {

        RuntimeQualityAnalysisDefinition rqa = repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Runtime Quality Analysis Definition with id: " + id + "."));

            boolean added = rqa.getRuntimeQualityAnalysis().getLoadTestDefinition().add(entity);
            if(!added) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "A Loadtest with the same name already exists.");
            }
            RuntimeQualityAnalysisDefinition savedRqaDef =  repository.save(rqa);
            return savedRqaDef;
    }
}
