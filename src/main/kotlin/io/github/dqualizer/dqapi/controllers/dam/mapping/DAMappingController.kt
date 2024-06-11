package io.github.dqualizer.dqapi.controllers.dam.mapping

import io.github.dqualizer.dqapi.services.dam.mapping.DAMappingService
import io.github.dqualizer.dqlang.types.dam.domainstory.Activity
import io.github.dqualizer.dqlang.types.dam.mapping.DAMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.server.ServerHttpRequest
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v2/dam/da-mapping")
class DAMappingController(
  @Autowired val service: DAMappingService,
) {
  @GetMapping
  fun all(): ResponseEntity<List<DAMapping>> {
    return ResponseEntity.ok(service.readAll().toList())
  }

  @GetMapping("/{id}")
  fun getById(@PathVariable id: String): ResponseEntity<DAMapping> {
    return ResponseEntity.ok(service.readById(id))
  }

  @PostMapping
  fun create(@RequestBody entity: Activity, serverHttpRequest: ServerHttpRequest): ResponseEntity<Activity> {
    val location = UriComponentsBuilder.fromUri(serverHttpRequest.uri)
      .path("{id}")
      .buildAndExpand(entity.id)
      .toUri()

    return ResponseEntity.created(location).body(service.create(entity))
  }
}
