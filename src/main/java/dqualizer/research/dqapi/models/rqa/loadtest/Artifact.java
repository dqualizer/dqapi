package dqualizer.research.dqapi.models.rqa.loadtest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artifact {
    @JsonProperty("object")
    private String objectId;
    @JsonProperty("activity")
    private String activityId;
}
