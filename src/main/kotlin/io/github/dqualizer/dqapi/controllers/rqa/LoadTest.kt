package io.github.dqualizer.dqapi.controllers.rqa

import io.github.dqualizer.dqapi.models.loadtestDefinition.CreateLoadtestDefinitionDto
import io.github.dqualizer.dqapi.services.rqa.RQALoadTestDefinitionService
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.LoadTestDefinition
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
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

  @DeleteMapping("/{rqaDefinitionId}/loadtest/{loadTestId}")
  fun delete(
    @PathVariable rqaDefinitionId: String,
    @PathVariable loadTestId: String
  ): ResponseEntity<LoadTestDefinition?> {
    return ResponseEntity(
      service.delete(rqaDefinitionId, loadTestId),
      HttpStatus.OK
    )
  }
}
