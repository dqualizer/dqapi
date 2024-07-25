package io.github.dqualizer.dqapi.controllers.rqa

import io.github.dqualizer.dqapi.models.monitoringDefinition.CreateMonitoringDefinitionDto
import io.github.dqualizer.dqapi.services.rqa.Monitoring
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.util.UriComponentsBuilder

class Monitoring(
  @Autowired val service: Monitoring,
  @Autowired val request: HttpServletRequest
) {
  @PatchMapping("/{rqaId}/monitoring")
  fun updateMonitoring(
    @PathVariable rqaId: String,
    @RequestBody entity: CreateMonitoringDefinitionDto,
  ): ResponseEntity<RuntimeQualityAnalysisDefinition> {
    val definition = entity.build()
    val rqa = service.create(rqaId, definition)

    val location = UriComponentsBuilder.fromUriString(request.requestURI)
      .path("/{id}")
      .buildAndExpand(rqa.id)
      .toUri()

    return ResponseEntity.created(location).body(rqa)
  }
}
