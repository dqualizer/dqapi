package dqualizer.research.dqapi.models.dst;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Actor {
    @Id
    private String id;
    private String name;
}
