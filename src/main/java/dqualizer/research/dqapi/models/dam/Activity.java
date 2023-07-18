package dqualizer.research.dqapi.models.dam;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class Activity {
    private  String activity_id;
    private String name;
    private String operation_id;
    private String initiator;
    private String workObject;
    private String action;
    private String type;
    private List<String> parameter;
    private Endpoint endpoint;
}
