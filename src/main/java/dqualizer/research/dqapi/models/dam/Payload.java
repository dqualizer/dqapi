package dqualizer.research.dqapi.models.dam;

import lombok.Data;

import java.util.List;

@Data
public class Payload {
    private String name;
    private List<Scenario> szenarios;

}
