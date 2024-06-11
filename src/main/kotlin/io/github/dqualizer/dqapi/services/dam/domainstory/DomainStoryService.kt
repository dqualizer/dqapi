package io.github.dqualizer.dqapi.services.dam.domainstory

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.repositories.dam.domainstory.DomainStoryRepository
import io.github.dqualizer.dqlang.types.dam.domainstory.DomainStory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DomainStoryService {
  @Autowired
  lateinit var repository: DomainStoryRepository

  fun readAll(): List<DomainStory> {
    return repository.findAll()
  }

  fun readAllIds(): List<String> {
    return repository.findAll().mapNotNull { it.id }
  }

  fun readById(id: String): DomainStory {
    return repository.findById(id).orElseThrow { NotFoundException("Could not find DomainStory with id: $id.") }
  }

  fun create(entity: DomainStory): DomainStory {
    return repository.save(entity)
  }
}
