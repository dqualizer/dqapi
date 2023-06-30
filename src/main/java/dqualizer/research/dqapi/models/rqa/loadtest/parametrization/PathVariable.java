package dqualizer.research.dqapi.models.rqa.loadtest.parametrization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathVariable {
    private String key;
    private String value;
}
