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
    @JsonProperty("stimulus_id")
    private String activityId;
    @NotBlank
    @JsonProperty("stimulus_type")
    private String stimulusType;
    @NotBlank
    private int accuracy;
    @JsonProperty("recovery_time")
    private Satisfaction recoveryTime;
    @JsonProperty("error_rate")
    private Satisfaction errorRate;
    @JsonProperty("response_time")
    private Satisfaction responseTime;
}
