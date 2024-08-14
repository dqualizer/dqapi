package io.github.dqualizer.dqapi.models.monitoringDefinition

import io.github.dqualizer.dqlang.types.rqa.definition.monitoring.MeasurementType
import io.github.dqualizer.dqlang.types.rqa.definition.monitoring.MonitoringDefinition
import java.util.*


data class CreateMonitoringDefinitionDto(
  val target: String,
  val measurementName: String,
  val measurementType: MeasurementType,
  val measurementUnit: String,
) {
  fun build(): MonitoringDefinition {
    val definition = MonitoringDefinition(
      target = target,
      measurementName = measurementName,
      measurementType = measurementType,
      measurementUnit = measurementUnit,
      id = UUID.randomUUID().toString()
    )
    return definition
  }
}
