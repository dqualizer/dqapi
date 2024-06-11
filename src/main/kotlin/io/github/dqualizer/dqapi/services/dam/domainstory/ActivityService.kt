package io.github.dqualizer.dqapi.services.dam.domainstory

import io.github.dqualizer.dqapi.exceptions.NotFoundException
import io.github.dqualizer.dqapi.repositories.dam.domainstory.ActivityRepository
import io.github.dqualizer.dqlang.types.dam.domainstory.Activity
import org.springframework.stereotype.Service

@Service
class ActivityService {
  lateinit var repository: ActivityRepository


  fun readAll(): List<Activity> {
    return repository.findAll()
  }

  fun readById(id: String): Activity {
    return repository.findById(id).orElseThrow { NotFoundException("Could not find Activity with id: $id.") }
  }

  fun create(entity: Activity?): Activity? {
    return null //TODO
  }
}
