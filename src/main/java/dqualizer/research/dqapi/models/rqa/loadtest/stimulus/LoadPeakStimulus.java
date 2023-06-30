package dqualizer.research.dqapi.models.rqa.loadtest.stimulus;

import dqualizer.research.dqapi.models.rqa.enums.HighestLoad;
import dqualizer.research.dqapi.models.rqa.enums.TimeToHighestLoad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoadPeakStimulus extends Stimulus {
    private HighestLoad highestLoad;
    private TimeToHighestLoad timeToHighestLoad;
}