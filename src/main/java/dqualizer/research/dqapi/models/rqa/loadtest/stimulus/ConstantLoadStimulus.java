package dqualizer.research.dqapi.models.rqa.loadtest.stimulus;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.BaseLoad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConstantLoadStimulus extends Stimulus{
    @JsonProperty("base_load")
    private BaseLoad baseLoad;
}
