package io.github.dqualizer.dqapi.services.rqa

import io.github.dqualizer.dqapi.models.rqa.CreateRQADto
import io.github.dqualizer.dqapi.repositories.rqa.RqaDefinitionRepository
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class RQADefinitionService(
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


}
