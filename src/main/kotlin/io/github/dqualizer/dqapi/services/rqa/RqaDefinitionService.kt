package io.github.dqualizer.dqapi.services.rqa

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.models.rqa.CreateRQADto
import io.github.dqualizer.dqapi.repositories.rqa.RqaDefinitionRepository
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.LoadTestDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.monitoring.MonitoringDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.ResilienceTestDefinition
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class RqaDefinitionService(
  @Autowired val repository: RqaDefinitionRepository
) {
  fun readAll(): List<RuntimeQualityAnalysisDefinition> {
    return repository.findAll()
  }

  fun readById(id: String): Optional<RuntimeQualityAnalysisDefinition> {
    return repository.findById(id)
  }

  fun create(entity: CreateRQADto): RuntimeQualityAnalysisDefinition {
    try {
      return repository.save(entity.build())
    } catch (e: DuplicateKeyException) {
      throw ResponseStatusException(HttpStatus.CONFLICT, "RqaDefinition with the same name already exists.", e)
    }
  }

  fun createLoadtest(id: String, entity: LoadTestDefinition): RuntimeQualityAnalysisDefinition {
    val rqa = repository.findById(id).orElseThrow {
      NotFoundException(
        "Could not find Runtime Quality Analysis Definition with id: $id."
      )
    }
    rqa.runtimeQualityAnalysis.loadTestDefinition.add(entity)

    val savedRqaDef = repository.save(rqa)
    return savedRqaDef
  }

  fun createMonitoring(id: String, entity: MonitoringDefinition): RuntimeQualityAnalysisDefinition {
    val rqa = repository.findById(id).orElseThrow {
      NotFoundException(
        "Could not find Runtime Quality Analysis Definition with id: $id."
      )
    }
    rqa.runtimeQualityAnalysis.monitoringDefinition.add(entity)

    val savedRqaDef = repository.save(rqa)
    return savedRqaDef
  }

  fun createResilience(id: String, entity: ResilienceTestDefinition): RuntimeQualityAnalysisDefinition {
    val rqa = repository.findById(id).orElseThrow {
      NotFoundException(
        "Could not find Runtime Quality Analysis Definition with id: $id."
      )
    }
    rqa.runtimeQualityAnalysis.resilienceTestDefinition.add(entity)

    val savedRqaDef = repository.save(rqa)
    return savedRqaDef
  }
}
