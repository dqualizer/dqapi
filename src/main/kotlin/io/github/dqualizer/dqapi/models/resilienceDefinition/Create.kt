package io.github.dqualizer.dqapi.models.resilienceDefinition

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.dqualizer.dqlang.types.rqa.definition.Artifact
import io.github.dqualizer.dqlang.types.rqa.definition.enums.Satisfaction
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.ResilienceResponseMeasures
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.ResilienceTestDefinition
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.stimulus.FailedRequestsStimulus
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.stimulus.LateResponsesStimulus
import io.github.dqualizer.dqlang.types.rqa.definition.resilience.stimulus.UnavailabilityStimulus


data class CreateResilienceTestDto(
  val name: String,
  val description: String,

  @JsonProperty("system_id")
  val systemId: String,

  @JsonProperty("activity_id")
  val activityId: String,

  @JsonProperty("stimulus_type")
  val stimulusType: String,

  @JsonProperty("pause_before_triggering_seconds")
  val pauseBeforeTriggeringSeconds: Int = 0,

  @JsonProperty("experiment_duration_seconds")
  val experimentDurationSeconds: Int = 0,

  @JsonProperty("delay_min_milliseconds")
  val minDelayMilliseconds: Int = 0,

  @JsonProperty("delay_max_milliseconds") val maxDelayMilliseconds: Int = 0,

  @JsonProperty("injection_frequency") val injectionFrequency: Int = 0,
  val recoveryTime: Satisfaction? = null,
  val errorRate: Satisfaction? = null,
  val responseTime: Satisfaction? = null
) {

  private fun getResilienceStimulus() =
    when (stimulusType) {
      "UNAVAILABILITY" -> UnavailabilityStimulus(
        pauseBeforeTriggeringSeconds,
        experimentDurationSeconds
      )

      "LATE_RESPONSES" -> LateResponsesStimulus(
        pauseBeforeTriggeringSeconds,
        experimentDurationSeconds,
        injectionFrequency,
        minDelayMilliseconds,
        maxDelayMilliseconds
      )

      "FAILED_REQUESTS" -> FailedRequestsStimulus(
        pauseBeforeTriggeringSeconds,
        experimentDurationSeconds,
        injectionFrequency
      )

      else -> throw IllegalArgumentException("Stimulus has no valid type")
    }

  fun build(): ResilienceTestDefinition {
    val artifact = Artifact(systemId, activityId)

    val resilienceStimulus = getResilienceStimulus()

    val responseMeasures = ResilienceResponseMeasures(
      recoveryTime = recoveryTime
    )
    return ResilienceTestDefinition(
      name,
      artifact,
      description,
      resilienceStimulus,
      responseMeasures
    )
  }
}
