package dqualizer.research.dqapi.models.rqa.loadtest.stimulus;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.HighestLoad;
import dqualizer.research.dqapi.models.rqa.enums.LoadProfile;
import dqualizer.research.dqapi.models.rqa.enums.TimeToHighestLoad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Stimulus {
    @JsonProperty("load_profile")
    private LoadProfile loadProfile;

    private int accuracy;

}