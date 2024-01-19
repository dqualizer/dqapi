package io.github.dqualizer.dqapi.repositories.rqa;

import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RqaDefinitionRepository extends MongoRepository<RuntimeQualityAnalysisDefinition, String> { }

