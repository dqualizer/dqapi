package dqualizer.research.dqapi.models.context;


import dqualizer.research.dqapi.models.dst.DomainStory;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class Context {

    @Indexed(unique = true)
    private String name;
    private DomainArchitectureMapping dam;
    private List<DomainStory> domainStories = new ArrayList<>();
    public Context(String name) {
        this.name = name;
    }
}
