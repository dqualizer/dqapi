package dqualizer.research.dqapi.models;

import dqualizer.research.dqapi.models.rqa.RqaDefinition;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Domain {
    @Id
    private String id;
    private List<RqaDefinition> rqaDefinitions;
}
