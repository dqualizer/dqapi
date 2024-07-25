package io.github.dqualizer.dqapi.controllers.rqa

import io.github.dqualizer.dqapi.models.rqa.CreateRQADto
import io.github.dqualizer.dqapi.services.rqa.Definition
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v2/rqa")
class Definition(
  @Autowired val service: Definition,
  @Autowired val request: HttpServletRequest
) {
  @GetMapping
  fun readAll(): ResponseEntity<List<RuntimeQualityAnalysisDefinition>> {
    return ResponseEntity.ok(service.readAll())
  }

  @GetMapping("/{id}")
  fun readById(@PathVariable id: String): ResponseEntity<RuntimeQualityAnalysisDefinition> {
    return ResponseEntity.of(service.readById(id))
  }

  @PostMapping
  fun create(
    @RequestBody entity: CreateRQADto,
  ): ResponseEntity<RuntimeQualityAnalysisDefinition> {
    val runtimeQualityAnalysisDefinition = service.create(entity)

    val location = UriComponentsBuilder.fromUriString(request.requestURI)
      .path("/{id}")
      .buildAndExpand(runtimeQualityAnalysisDefinition.id)
      .toUri()

    return ResponseEntity.created(location).body(runtimeQualityAnalysisDefinition)
  }
}
