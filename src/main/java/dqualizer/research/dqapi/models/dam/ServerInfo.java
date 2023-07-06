package dqualizer.research.dqapi.models.dam;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ServerInfo {

   @Id
    private String id;
    private String host;
    private String environment;
}
