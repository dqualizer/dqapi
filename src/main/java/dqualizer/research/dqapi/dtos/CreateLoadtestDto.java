package dqualizer.research.dqapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.*;
import dqualizer.research.dqapi.models.rqa.loadtest.parametrization.PathVariable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class CreateLoadtestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String system;
    @NotBlank
    private String activity;
    @NotBlank
    @JsonProperty("load_profile")
    private LoadProfile loadProfile;
    @NotBlank
    private int accuracy;
    private Map<String, String> designParameters = new HashMap<>();
    @NotBlank
    @JsonProperty("path_variables")
    private List<PathVariable> pathVariables;
    @NotBlank
    @JsonProperty("response_time")
    private ResponseTime responseTime;
    @NotBlank
    @JsonProperty("result_metrics")
    private Set<ResultMetrics> resultMetrics;

}
