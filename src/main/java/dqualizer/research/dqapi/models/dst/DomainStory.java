package dqualizer.research.dqapi.models.dst;

import dqualizer.research.dqapi.models.context.Context;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
public class DomainStory {
    private String name;
    private List<Actor> actors;
    private List<WorkObject> workObjects;

    private List<Activity> activities;

    public DomainStory(String name, Context context) {
        this.name = name;
    }
}
