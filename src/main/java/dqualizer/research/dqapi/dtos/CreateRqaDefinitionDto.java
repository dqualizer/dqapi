package dqualizer.research.dqapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import dqualizer.research.dqapi.models.rqa.enums.Environment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreateRqaDefinitionDto {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private Environment environment;
    @NotNull
    @NotBlank
    @JsonProperty("domain_id")
    private String domainId;

    @NotNull
    @NotBlank
    private String context;
}
