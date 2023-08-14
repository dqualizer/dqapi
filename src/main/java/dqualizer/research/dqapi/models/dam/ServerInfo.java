package dqualizer.research.dqapi.models.dam;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class ServerInfo {

    private String id;
    private String host;
    private String environment;

    public ServerInfo() {
        this.id = new ObjectId().toHexString();
    }
}
