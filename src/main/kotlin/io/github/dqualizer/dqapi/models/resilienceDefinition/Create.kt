package io.github.dqualizer.dqapi.models.resilienceDefinition

import io.github.dqualizer.dqlang.types.rqa.definition.Artifact
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.ResilienceResponseMeasures
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.ResilienceTestDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.stimulus.ResilienceStimulus


data class CreateResilienceTestDefinitionDto(
  val name: String,
  val artifact: Artifact,
  val description: String,
  val stimulus: ResilienceStimulus,
  val responseMeasures: ResilienceResponseMeasures
) {
  fun build(): ResilienceTestDefinition {
    val resilienceTestDefinition = ResilienceTestDefinition(
      name,
      artifact,
      description,
      stimulus,
      responseMeasures
    )
    return resilienceTestDefinition
  }
}
