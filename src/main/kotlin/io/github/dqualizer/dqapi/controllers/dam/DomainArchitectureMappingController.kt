package io.github.dqualizer.dqapi.controllers.dam

import io.github.dqualizer.dqapi.services.dam.DomainArchitectureMappingService
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/dam")
class DomainArchitectureMappingController(
  @Autowired val service: DomainArchitectureMappingService
) {
  @GetMapping
  fun readAll(): ResponseEntity<List<DomainArchitectureMapping>> {
    return ResponseEntity.ok(service.readAll())
  }

  @GetMapping("/{id}")
  fun readById(@PathVariable id: String): ResponseEntity<DomainArchitectureMapping> {
    return ResponseEntity.of(service.readById(id))
  }

  @GetMapping("/domain-story/{id}")
  fun readByDomainStoryId(@PathVariable id: String): ResponseEntity<DomainArchitectureMapping> {
    return ResponseEntity.of(service.readByDomainStoryId(id))
  }

  @PostMapping
  fun create(@RequestBody entity: DomainArchitectureMapping): ResponseEntity<DomainArchitectureMapping> {
    return ResponseEntity.ok(service.create(entity))
  }
}
