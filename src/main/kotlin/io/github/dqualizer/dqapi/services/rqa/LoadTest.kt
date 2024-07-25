package io.github.dqualizer.dqapi.services.rqa

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.repositories.rqa.RqaDefinitionRepository
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.LoadTestDefinition
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RQALoadTestDefinitionService(
  @Autowired val repository: RqaDefinitionRepository
) {
  fun create(id: String, entity: LoadTestDefinition): RuntimeQualityAnalysisDefinition {
    val rqa = repository.findById(id).orElseThrow {
      NotFoundException(
        "Could not find Runtime Quality Analysis Definition with id: $id."
      )
    }
    rqa.runtimeQualityAnalysis.loadTestDefinition.add(entity)

    val savedRqaDef = repository.save(rqa)
    return savedRqaDef
  }
}