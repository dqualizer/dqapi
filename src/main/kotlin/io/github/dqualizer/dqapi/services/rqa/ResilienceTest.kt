package io.github.dqualizer.dqapi.services.rqa

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.models.resilienceDefinition.CreateResilienceTestDto
import io.github.dqualizer.dqapi.repositories.rqa.RqaDefinitionRepository
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.ResilienceTestDefinition
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class RQAResilienceTestService(
  @Autowired val repository: RqaDefinitionRepository
) {
  fun create(id: String, entity: ResilienceTestDefinition): RuntimeQualityAnalysisDefinition {
    val rqa = repository.findById(id).orElseThrow {
      NotFoundException(
        "Could not find Runtime Quality Analysis Definition with id: $id."
      )
    }
    rqa.runtimeQualityAnalysis.resilienceTestDefinition.add(entity)

    val savedRqaDef = repository.save(rqa)
    return savedRqaDef
  }

  fun delete(rqaDefinitionId: String): RuntimeQualityAnalysisDefinition {
    val rqaDefinition: RuntimeQualityAnalysisDefinition = repository.findById(rqaDefinitionId)
      .orElseThrow { java.lang.IllegalStateException("No RQA Definition with id \"$rqaDefinitionId\" found.") }

    val runtimeQualityAnalysis = rqaDefinition.runtimeQualityAnalysis
    runtimeQualityAnalysis.resilienceTestDefinition.clear()

    repository.save(rqaDefinition)

    return rqaDefinition
  }

  fun deleteByName(rqaDefinitionId: String, resilienceTestName: String): RuntimeQualityAnalysisDefinition {

    val rqaDefinition = repository.findById(rqaDefinitionId)
      .orElseThrow { throw IllegalStateException("No RQA Definition found with id: $rqaDefinitionId") }

    val runtimeQualityAnalysis = rqaDefinition.runtimeQualityAnalysis

    // Get the list of resilienceTestDefinitions from the runtimeQualityAnalysis
    val resilienceTestDefinitions = runtimeQualityAnalysis.resilienceTestDefinition

    // Find the loadtest to be removed
    val resilienceTestToRemove =
      resilienceTestDefinitions.find { it.name == resilienceTestName } ?: throw IllegalStateException(
        "No ResilienceTest with name $resilienceTestName found in RQA Definition."
      )

    resilienceTestDefinitions.remove(resilienceTestToRemove)

    // Save the updated RqaDefinition back to the repository
    repository.save(rqaDefinition)

    return rqaDefinition
  }

  fun update(
    resilienceTestDto: CreateResilienceTestDto,
    rqaDefinitionId: String
  ): RuntimeQualityAnalysisDefinition {
    val resilienceTest = resilienceTestDto.build()

    return repository.findById(rqaDefinitionId).map { rqaDefinition ->
      rqaDefinition.runtimeQualityAnalysis.resilienceTestDefinition.add(resilienceTest)
      repository.save(rqaDefinition)
      rqaDefinition
    }.orElseThrow { java.lang.IllegalStateException("No RQA Definition with id \"$rqaDefinitionId\" found.") }
  }
}
