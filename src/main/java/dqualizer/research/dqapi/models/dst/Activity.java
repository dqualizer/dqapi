package dqualizer.research.dqapi.models.dst;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Activity {
    @Id
    private String id;
    private int step;
    private String description;
    private String name;
    @DBRef
    private List<Connection> connections;
}
