package io.github.dqualizer.dqapi.models.rqa

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysis
import io.github.dqualizer.dqlang.types.rqa.definition.RuntimeQualityAnalysisDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.enums.Environment

data class CreateRQADto(
  val name: String,
  @JsonProperty("domain_id")
  val domainId: String,
  val context: String,
  val environment: Environment,
) {
  fun build(): RuntimeQualityAnalysisDefinition {
    val version = "1"
    return RuntimeQualityAnalysisDefinition(
      name,
      version,
      domainId,
      context,
      environment,
      runtimeQualityAnalysis = RuntimeQualityAnalysis()
    )
  }
}
