package dqualizer.research.dqapi.models.rqa.loadtest;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.loadtest.parametrization.Parametrization;
import dqualizer.research.dqapi.models.rqa.loadtest.parametrization.ResponseMeasures;
import dqualizer.research.dqapi.models.rqa.loadtest.stimulus.Stimulus;
import dqualizer.research.dqapi.models.rqa.enums.ResultMetrics;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Loadtest {
    @Indexed(unique = true)
    private String name;
    private Artifact artifact;
    private String description;
    private Stimulus stimulus;
    private Parametrization parametrization;
    @JsonProperty("response_measure")
    private ResponseMeasures responseMeasures;
    @JsonProperty("result_metrics")
    private Set<ResultMetrics> resultMetrics;

    public Loadtest(String name, Artifact artifact, String description, Stimulus stimulus, Parametrization parametrization, ResponseMeasures responseMeasures, Set<ResultMetrics> resultMetrics) {
        this.name = name;
        this.artifact = artifact;
        this.description = description;
        this.stimulus = stimulus;
        this.parametrization = parametrization;
        this.responseMeasures = responseMeasures;
        this.resultMetrics = resultMetrics;
    }
}
