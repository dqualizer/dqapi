package io.github.dqualizer.dqapi.services.dam.mapping

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.repositories.dam.mapping.DAMappingRepository
import io.github.dqualizer.dqlang.types.dam.domainstory.Activity
import io.github.dqualizer.dqlang.types.dam.mapping.DAMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DAMappingService(
  @Autowired val repository: DAMappingRepository
) {
  fun readAll(): MutableList<DAMapping> {
    return repository.findAll()
  }

  fun readById(id: String): DAMapping? {
    return repository.findById(id).orElseThrow {
      NotFoundException(
        "Could not find DA-Mapping with id: $id."
      )
    }
  }

  fun create(entity: Activity?): Activity? {
    TODO()
  }
}
