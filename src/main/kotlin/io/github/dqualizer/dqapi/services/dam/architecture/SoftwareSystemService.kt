package io.github.dqualizer.dqapi.services.dam.architecture

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.repositories.dam.architecture.SoftwareSystemRepository
import io.github.dqualizer.dqlang.types.dam.architecture.SoftwareSystem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SoftwareSystemService {
  @Autowired
  lateinit var repository: SoftwareSystemRepository

  fun readAll(): List<SoftwareSystem> {
    return repository.findAll()
  }

  fun readById(id: String): SoftwareSystem {
    return repository.findById(id).orElseThrow { NotFoundException("Could not find SoftwareSystem with id: $id.") }
  }

  fun create(entity: SoftwareSystem?): SoftwareSystem? {
    TODO()
  }
}
