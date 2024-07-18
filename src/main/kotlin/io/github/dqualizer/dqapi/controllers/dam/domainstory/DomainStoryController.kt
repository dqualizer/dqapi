package io.github.dqualizer.dqapi.controllers.dam.domainstory

import io.github.dqualizer.dqapi.services.dam.domainstory.DomainStoryService
import io.github.dqualizer.dqlang.types.dam.domainstory.DomainStory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v2/domain-story")
class DomainStoryController(
  @Autowired val service: DomainStoryService
) {
  @GetMapping
  fun readAll(): ResponseEntity<List<DomainStory>> {
    return ResponseEntity.ok(service.readAll())
  }

  @GetMapping("/ids")
  fun readAllIds(): ResponseEntity<List<String>> {
    return ResponseEntity.ok(service.readAllIds())
  }

  @GetMapping("/{id}")
  fun readById(@PathVariable id: String): ResponseEntity<DomainStory> {
    return ResponseEntity.ok(service.readById(id))
  }

  @PostMapping
  fun create(@RequestBody entity: DomainStory, serverHttpRequest: ServerHttpRequest): ResponseEntity<DomainStory> {
    val location = UriComponentsBuilder.fromUri(serverHttpRequest.uri)
      .path("{id}")
      .buildAndExpand(entity.id)
      .toUri()

    return ResponseEntity.created(location).body(service.create(entity))
  }
}
