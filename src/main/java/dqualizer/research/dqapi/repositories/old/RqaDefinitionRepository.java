package dqualizer.research.dqapi.repositories.old;

import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RqaDefinitionRepository extends MongoRepository<RuntimeQualityAnalysisDefinition, String> {

    Optional<RuntimeQualityAnalysisDefinition> findByName(String name);
    Optional<RuntimeQualityAnalysisDefinition> findByNameOrId(String name, String id);
}
