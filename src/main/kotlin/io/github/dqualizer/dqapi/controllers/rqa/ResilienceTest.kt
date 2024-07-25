package io.github.dqualizer.dqapi.controllers.rqa

import io.github.dqualizer.dqapi.models.resilienceDefinition.CreateResilienceTestDto
import io.github.dqualizer.dqapi.services.rqa.ResilienceTest
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v2/rqa")
class RQAResilienceTestDefinitionController(
  @Autowired val service: ResilienceTest,
  @Autowired val request: HttpServletRequest
) {
  @PatchMapping("/{rqaId}/resilience-test")
  fun updateResilienceTest(
    @PathVariable rqaId: String,
    @RequestBody dto: CreateResilienceTestDto,
  ): ResponseEntity<RuntimeQualityAnalysisDefinition> {
    val rqa = service.create(rqaId, dto.build())

    val location = UriComponentsBuilder.fromUriString(request.requestURI)
      .path("/{id}")
      .buildAndExpand(rqa.id)
      .toUri()

    return ResponseEntity.created(location).body(rqa)
  }

  @DeleteMapping("/{rqaDefinitionId}/resilienceTests")
  fun delete(@PathVariable rqaDefinitionId: String): ResponseEntity<RuntimeQualityAnalysisDefinition?> {
    return ResponseEntity(
      service.delete(rqaDefinitionId),
      HttpStatus.OK
    )
  }

  @DeleteMapping("/{rqaDefinitionId}/resilienceTest/{resilienceTestName}")
  fun deleteById(
    @PathVariable rqaDefinitionId: String,
    @PathVariable resilienceTestName: String
  ): RuntimeQualityAnalysisDefinition {
    return service.deleteByName(rqaDefinitionId, resilienceTestName)
  }
}
