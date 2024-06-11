package io.github.dqualizer.dqapi.controllers.dam.architecture

import io.github.dqualizer.dqapi.services.dam.architecture.SoftwareSystemService
import io.github.dqualizer.dqlang.types.dam.architecture.SoftwareSystem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/dam/architecture/software-system")
class SoftwareSystemController(
  @Autowired val service: SoftwareSystemService
) {
  @GetMapping
  fun all(): ResponseEntity<List<SoftwareSystem>> {
    return ResponseEntity.ok(service.readAll())
  }

  @GetMapping("/{id}")
  fun getById(@PathVariable id: String): ResponseEntity<SoftwareSystem> {
    val softwareSystem = service.readById(id)
    return ResponseEntity(softwareSystem, HttpStatus.FOUND)
  }

  @PostMapping
  fun create(@RequestBody entity: SoftwareSystem): ResponseEntity<SoftwareSystem> {
    return ResponseEntity.ok(service.create(entity))
  }
}
