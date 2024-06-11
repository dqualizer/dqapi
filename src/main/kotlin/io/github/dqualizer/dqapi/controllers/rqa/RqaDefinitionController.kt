package io.github.dqualizer.dqapi.controllers.rqa

import io.github.dqualizer.dqapi.models.rqa.CreateRQADto
import io.github.dqualizer.dqapi.services.rqa.RqaDefinitionService
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.LoadTestDefinition
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.server.ServerHttpRequest
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v2/rqa")
class RqaDefinitionController(
  @Autowired val service: RqaDefinitionService,
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
    val runtimeQualityAnalysisDefinition: RuntimeQualityAnalysisDefinition = service.create(entity)

    println(request.requestURL)
    println(request.requestURI)
    val location = UriComponentsBuilder.fromUriString(request.requestURI)
      .path("/{id}")
      .buildAndExpand(runtimeQualityAnalysisDefinition.id)
      .toUri()

    println(location)

    return ResponseEntity.created(location).body(runtimeQualityAnalysisDefinition)
  }

  @PostMapping("/{rqaId}/loadtest")
  fun createLoadtest(
    @PathVariable rqaId: String,
    @RequestBody entity: LoadTestDefinition,
    serverHttpRequest: ServerHttpRequest
  ): ResponseEntity<RuntimeQualityAnalysisDefinition> {
    val rqa: RuntimeQualityAnalysisDefinition = service.createLoadtest(rqaId, entity)

    val location: URI = UriComponentsBuilder.fromUri(serverHttpRequest.uri)
      .path("$rqaId/loadtest/{id}")
      .buildAndExpand(rqa.id)
      .toUri()

    return ResponseEntity.created(location).body(rqa)
  }
}
