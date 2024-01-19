package io.github.dqualizer.dqapi.models.context;


import io.github.dqualizer.dqapi.models.dst.DomainStory;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
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
