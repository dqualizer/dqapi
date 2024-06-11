package io.github.dqualizer.dqapi.services.dam.architecture

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.repositories.dam.architecture.ServiceDescriptionRepository
import io.github.dqualizer.dqlang.types.dam.architecture.ServiceDescription
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServiceDescriptionService {
  @Autowired
  lateinit var repository: ServiceDescriptionRepository

  fun readAll(): List<ServiceDescription> {
    return repository.findAll()
  }

  fun readById(id: String): ServiceDescription {
    return repository.findById(id).orElseThrow { NotFoundException("Could not find Service-Description with id: $id.") }
  }

  fun create(entity: ServiceDescription?): ServiceDescription? {
    TODO()
  }
}
