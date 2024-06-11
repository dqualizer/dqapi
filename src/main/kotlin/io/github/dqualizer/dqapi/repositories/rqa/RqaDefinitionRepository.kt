package io.github.dqualizer.dqapi.repositories.rqa

import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RqaDefinitionRepository : MongoRepository<RuntimeQualityAnalysisDefinition, String>

