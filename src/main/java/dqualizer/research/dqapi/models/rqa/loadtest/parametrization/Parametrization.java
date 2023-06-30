package dqualizer.research.dqapi.models.rqa.loadtest.parametrization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parametrization {
    @JsonProperty("path_variables")
    private List<PathVariable> pathVariables;
}
