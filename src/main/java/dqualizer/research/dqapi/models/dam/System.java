package dqualizer.research.dqapi.models.dam;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
public class System {
    @Id
    private String id;
    private String name;
    private String operation_id;
    private String type;
    @JsonProperty("implements")
    private List<Object> myimplements;
    private List<String> objects;

    private List<Activity> activities;

    public System() {
        this.id = new ObjectId().toHexString();
    }
}
