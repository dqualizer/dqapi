package io.github.dqualizer.dqapi.controllers.dam.architecture

import io.github.dqualizer.dqapi.services.dam.architecture.ServiceDescriptionService
import io.github.dqualizer.dqlang.types.dam.architecture.ServiceDescription
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/dam/architecture/service-description")
class ServiceDescriptionController {
  @Autowired
  lateinit var service: ServiceDescriptionService

  @get:GetMapping
  val all: ResponseEntity<List<ServiceDescription>>
    get() {
      val serviceDescriptions = service.readAll()
      return ResponseEntity(serviceDescriptions, HttpStatus.FOUND)
    }

  @GetMapping("/{id}")
  fun getById(@PathVariable id: String): ResponseEntity<ServiceDescription> {
    val serviceDescription = service.readById(id)
    return ResponseEntity(serviceDescription, HttpStatus.FOUND)
  }

  @PostMapping
  fun create(@RequestBody entity: ServiceDescription): ResponseEntity<ServiceDescription> {
    val serviceDescription = service.create(entity)
    return ResponseEntity(serviceDescription, HttpStatus.CREATED)
  }
}
