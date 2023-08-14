package dqualizer.research.dqapi.models.dam;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Actor{
    private String id;
    private String actor_name;

    public Actor() {
        this.id = new ObjectId().toHexString();
    }
}
