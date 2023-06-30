package dqualizer.research.dqapi.models.rqa.loadtest.parametrization;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.ResponseTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMeasures {
    @JsonProperty("response_time")
    private ResponseTime responseTime;
}
