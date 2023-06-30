package dqualizer.research.dqapi.models.rqa;

import dqualizer.research.dqapi.models.rqa.enums.Environment;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class RqaDefinition {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String version;
    private String domainId;
    private Environment environment;
    private RuntimeQualityAnalysis runtimeQualityAnalysis;

    public RqaDefinition(String name, String version, Environment environment, RuntimeQualityAnalysis runtimeQualityAnalysis) {
        this.name = name;
        this.version = version;
        this.environment = environment;
        this.runtimeQualityAnalysis = runtimeQualityAnalysis;
    }
}
