package dqualizer.research.dqapi.models.rqa.loadtest.parametrization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parametrization {
    @JsonProperty("path_variables")
    private Map<String, String> pathVariables;
}
