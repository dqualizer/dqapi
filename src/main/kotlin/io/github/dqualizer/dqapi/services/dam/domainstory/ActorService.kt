package io.github.dqualizer.dqapi.services.dam.domainstory

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqlang.types.dam.domainstory.Actor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ActorService {
  @Autowired
  lateinit var repository: io.github.dqualizer.dqapi.repositories.dam.domainstory.ActorRepository

  fun readAll(): List<Actor> {
    return repository.findAll()
  }

  fun readById(id: String): Actor {
    return repository.findById(id).orElseThrow { NotFoundException("Could not find Actor with id: $id.") }
  }

  fun create(entity: Actor?): Actor? {
    TODO()
  }
}
