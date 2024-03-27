package dqualizer.research.dqapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.dqualizer.dqlang.types.rqa.definition.enums.Satisfaction;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateResilienceTestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    @JsonProperty("system_id")
    private String systemId;
    @JsonProperty("activity_id")
    private String activityId;
    @NotBlank
    @JsonProperty("stimulus_type")
    private String stimulusType;
    @JsonProperty("pause_before_triggering_seconds")
    private int pauseBeforeTriggeringSeconds;
    @JsonProperty("experiment_duration_seconds")
    private int experimentDurationSeconds;
    @JsonProperty("delay_min_milliseconds")
    private int minDelayMilliseconds;
    @JsonProperty("delay_max_milliseconds")
    private int maxDelayMilliseconds;
    @JsonProperty("injection_frequency")
    private int injectionFrequency;
    @JsonProperty("recovery_time")
    private Satisfaction recoveryTime;
    @JsonProperty("error_rate")
    private Satisfaction errorRate;
    @JsonProperty("response_time")
    private Satisfaction responseTime;
}
