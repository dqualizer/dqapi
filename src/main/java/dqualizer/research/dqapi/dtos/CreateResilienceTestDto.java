package dqualizer.research.dqapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.dqualizer.dqlang.types.rqa.definition.enums.LoadProfile;
import io.github.dqualizer.dqlang.types.rqa.definition.enums.ResultMetrics;
import io.github.dqualizer.dqlang.types.rqa.definition.enums.Satisfaction;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
public class CreateResilienceTestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String system;
    @NotBlank
    private int accuracy;
    @NotBlank
    @JsonProperty("stimulus_type")
    private String stimulusType;
    @NotBlank
    @JsonProperty("recovery_time")
    private Satisfaction recoveryTime;
}
