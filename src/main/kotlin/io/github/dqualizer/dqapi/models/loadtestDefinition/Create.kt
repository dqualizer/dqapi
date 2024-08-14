package io.github.dqualizer.dqapi.models.loadtestDefinition

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.dqualizer.dqlang.types.rqa.definition.Artifact
import io.github.dqualizer.dqlang.types.rqa.definition.enums.ResultMetrics
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.LoadTestDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.ResponseMeasures
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.parametrization.Parametrization
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.parametrization.PathVariable
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.parametrization.Payload
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.parametrization.Scenario
import io.github.dqualizer.dqlang.types.rqa.definition.loadtest.stimulus.Stimulus
import java.util.*


data class CreateLoadtestDefinitionDto(
  val name: String?,
  val artifact: Artifact?,
  val description: String?,
  val stimulus: Stimulus?,
  val parametrization: Parametrization?,

  @JsonProperty("response_measure")
  val responseMeasures: ResponseMeasures?,

  @JsonProperty("result_metrics")
  val resultMetrics: Set<ResultMetrics>?
) {
  // TODO: frontend needs to do this
  fun build(): LoadTestDefinition {
    val pathVariables = HashSet<PathVariable>()
    val pathVariablesScenario = Scenario(
      name = "valid",
      path = "auftrag/auftragsnummern/angelegt.json"
    )
    val pathVariable = PathVariable(
      name = "auftragsnummer",
      scenarios = mutableListOf(pathVariablesScenario)
    )
    pathVariables.add(pathVariable)

    val parametrization = Parametrization(
      pathVariables = pathVariables,
      payload = Payload(),
    )

    val ltd = LoadTestDefinition(
      name,
      artifact,
      description,
      stimulus,
      parametrization,
      responseMeasures,
      resultMetrics
    )

    ltd.id = UUID.randomUUID().toString()

    return ltd
  }
}
