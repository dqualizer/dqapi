package dqualizer.research.dqapi.models.rqa.loadtest.stimulus;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.HighestLoad;
import dqualizer.research.dqapi.models.rqa.enums.TimeToHighestLoad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoadPeakStimulus extends Stimulus {

    @JsonProperty("highest_load")
    private HighestLoad highestLoad;
    @JsonProperty("time_to_highest_load")

    private TimeToHighestLoad timeToHighestLoad;
}