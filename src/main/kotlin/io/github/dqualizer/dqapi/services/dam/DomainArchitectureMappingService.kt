package io.github.dqualizer.dqapi.services.dam

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.MongoWriteException
import io.github.dqualizer.dqapi.exceptions.DuplicateEntityException
import io.github.dqualizer.dqapi.repositories.dam.DomainArchitectureMappingRepository
import io.github.dqualizer.dqapi.repositories.dam.architecture.ServiceDescriptionRepository
import io.github.dqualizer.dqapi.repositories.dam.architecture.SoftwareSystemRepository
import io.github.dqualizer.dqapi.repositories.dam.domainstory.DomainStoryRepository
import io.github.dqualizer.dqlang.data.DqualizerRepositories
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service
import java.util.*

@Service
class DomainArchitectureMappingService(
  @Autowired val repository: DomainArchitectureMappingRepository,
  @Autowired val domainStoryRepository: DomainStoryRepository,
  @Autowired val softwareSystemRepository: SoftwareSystemRepository,
  @Autowired val serviceDescriptionRepository: ServiceDescriptionRepository,
  @Autowired val mapper: ObjectMapper,
  @Autowired val resourceLoader: ResourceLoader,
) {
  fun readAll(): List<DomainArchitectureMapping> {
    return repository.findAll()
  }

  fun readById(id: String): Optional<DomainArchitectureMapping> {
    return repository.findById(id)
  }

  fun readByDomainStoryId(id: String): Optional<DomainArchitectureMapping> {
    return Optional.ofNullable(repository.findAll().find { it.domainStory.id == id })
  }

  fun create(entity: DomainArchitectureMapping): DomainArchitectureMapping {
    try {
      val dam = repository.insert(entity)
      return dam
    } catch (e: MongoWriteException) {
      throw DuplicateEntityException(e.message)
    }
  }

  /**
   * Insert DAM into Mongo repository at application start
   */
  @PostConstruct
  fun init() {
    val dam = loadDAM()

    dam.store(
      DqualizerRepositories(
        repository,
        softwareSystemRepository,
        domainStoryRepository,
        serviceDescriptionRepository,
      )
    )
  }

  /**
   * Load local DAM json and convert to java object
   */
  fun loadDAM(): DomainArchitectureMapping {
    val fileName = "werkstatt-dam.json"
    val resource = resourceLoader.getResource("classpath:$fileName")
    val damString = resource.getContentAsString(Charsets.UTF_8)
    val dam = mapper.readValue(damString, DomainArchitectureMapping::class.java)
    return dam
  }
}
