package dqualizer.research.dqapi.dtos;

import dqualizer.research.dqapi.models.dam.Actor;
import dqualizer.research.dqapi.models.dam.DomainArchitectureMapping;
import dqualizer.research.dqapi.models.dam.ServerInfo;
import dqualizer.research.dqapi.models.dam.System;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class CreateDamDto {
    @NotNull
    public int version;
    @NotBlank
    public String context;

    @NotNull
    public List<ServerInfo> server_info;
    @NotNull
    public List<Actor> actors;
    @NotNull
    public List<System> systems;
}
