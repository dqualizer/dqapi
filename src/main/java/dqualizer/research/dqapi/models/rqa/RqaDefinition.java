package dqualizer.research.dqapi.models.rqa;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.Environment;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.PathVariable;

@Data
@Document
public class RqaDefinition {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String version;
    @JsonProperty("domain_id")
    @NotNull
    private String domainId;
    private String context;
    private Environment environment;
    @JsonProperty("runtime_quality_analysis")
    private RuntimeQualityAnalysis runtimeQualityAnalysis;

    public RqaDefinition(String name, String version, Environment environment, String domainId, RuntimeQualityAnalysis runtimeQualityAnalysis, String context) {
        this.name = name;
        this.version = version;
        this.environment = environment;
        this.domainId = domainId;
        this.runtimeQualityAnalysis = runtimeQualityAnalysis;
        this.context = context;
    }
}
