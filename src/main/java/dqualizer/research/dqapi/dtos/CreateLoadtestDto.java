package dqualizer.research.dqapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.*;
import dqualizer.research.dqapi.models.rqa.loadtest.parametrization.PathVariable;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CreateLoadtestDto {
    private String name;
    private String object;
    private String activity;
    @JsonProperty("load_profile")
    private LoadProfile loadProfile;
    private int accuracy;
    @JsonProperty("highest_load")
    private HighestLoad highestLoad;
    @JsonProperty("time_to_highest_load")
    private TimeToHighestLoad timeToHighestLoad;
    @JsonProperty("path_variables")
    private List<PathVariable> pathVariables;
    @JsonProperty("response_time")
    private ResponseTime responseTime;
    @JsonProperty("result_metrics")
    private Set<ResultMetrics> resultMetrics;

}
