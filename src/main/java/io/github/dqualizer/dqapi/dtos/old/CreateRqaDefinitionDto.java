package io.github.dqualizer.dqapi.dtos.old;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.dqualizer.dqlang.types.rqa.definition.enums.Environment;
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
