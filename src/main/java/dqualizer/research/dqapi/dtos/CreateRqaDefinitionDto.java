package dqualizer.research.dqapi.dtos;

import dqualizer.research.dqapi.models.rqa.enums.Environment;
import lombok.Data;

@Data
public class CreateRqaDefinitionDto {
    private String name;
    private Environment environment;
}
