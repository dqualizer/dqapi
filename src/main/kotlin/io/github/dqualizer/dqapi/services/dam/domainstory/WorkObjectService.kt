package io.github.dqualizer.dqapi.services.dam.domainstory

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.repositories.dam.domainstory.WorkObjectRepository
import io.github.dqualizer.dqlang.types.dam.domainstory.WorkObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WorkObjectService {
  @Autowired
  lateinit var repository: WorkObjectRepository

  fun readAll(): MutableList<WorkObject> {
    return repository.findAll()
  }

  fun readById(id: String): WorkObject? {
    return repository.findById(id).orElseThrow { NotFoundException("Could not find WorkObject with id: $id.") }
  }

  fun create(entity: WorkObject?): WorkObject? {
    TODO()
  }
}
