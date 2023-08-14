package dqualizer.research.dqapi.models.rqa.loadtest.stimulus;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.TypeOfIncrease;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoadIncreaseStimulus extends Stimulus {
    @JsonProperty("type_of_increase")
    private TypeOfIncrease typeOfIncrease;
}
