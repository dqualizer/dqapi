package io.github.dqualizer.dqapi.controllers.rqa

import io.github.dqualizer.dqapi.models.loadtestDefinition.CreateLoadtestDefinitionDto
import io.github.dqualizer.dqapi.services.rqa.RQALoadTestDefinitionService
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/api/v2/rqa")
class RQALoadTestDefinitionController(
  @Autowired val service: RQALoadTestDefinitionService,
  @Autowired val request: HttpServletRequest
) {
  @PatchMapping("/{rqaId}/loadtest")
  fun updateLoadtest(
    @PathVariable rqaId: String,
    @RequestBody entity: CreateLoadtestDefinitionDto,
  ): ResponseEntity<RuntimeQualityAnalysisDefinition> {
    val loadTestDefinition = entity.build()
    val rqa = service.create(rqaId, loadTestDefinition)

    val location = UriComponentsBuilder.fromUriString(request.requestURI)
      .path("/{id}")
      .buildAndExpand(rqa.id)
      .toUri()

    return ResponseEntity.created(location).body(rqa)
  }
}