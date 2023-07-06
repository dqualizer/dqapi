package dqualizer.research.dqapi.models.dam;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class DomainArchitectureMapping {
    @Id
    private String id;
    private int version;
    private String context;
    @DBRef
    private List<ServerInfo> server_info;
    @DBRef
    private List<Actor> actors;
    @DBRef
    private List<System> systems;

    public DomainArchitectureMapping(int version, String context, List<ServerInfo> server_info, List<Actor> actors, List<System> systems) {
        this.version = version;
        this.context = context;
        this.server_info = server_info;
        this.actors = actors;
        this.systems = systems;
    }
}
