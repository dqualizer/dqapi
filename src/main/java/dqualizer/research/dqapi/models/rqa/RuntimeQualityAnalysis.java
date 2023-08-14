package dqualizer.research.dqapi.models.rqa;

import dqualizer.research.dqapi.models.rqa.loadtest.Loadtest;
import dqualizer.research.dqapi.models.rqa.monitoring.Monitoring;
import dqualizer.research.dqapi.models.rqa.resilience.Resilience;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RuntimeQualityAnalysis {
    public List<Loadtest> loadtests = new ArrayList<>();
    public List<Monitoring> monitoring = new ArrayList<>();
    public List<Resilience> resilience = new ArrayList<>();
}
