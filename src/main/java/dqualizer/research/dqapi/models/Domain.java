package dqualizer.research.dqapi.models;

import dqualizer.research.dqapi.models.context.Context;
import dqualizer.research.dqapi.models.rqa.RqaDefinition;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Domain {
    @Id
    private String id;
    @Indexed(unique = true)
    @Field("name")
    private String name;
    private List<Context> contexts = new ArrayList<>();
    private List<SubDomain> subdomains = new ArrayList<>();
    public Domain(String name) {
        this.name = name;
    }
}
