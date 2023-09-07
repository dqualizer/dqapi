package dqualizer.research.dqapi.dtos;


import io.github.dqualizer.dqlang.types.dam.Actor;
import io.github.dqualizer.dqlang.types.dam.ServerInfo;
import io.github.dqualizer.dqlang.types.dam.System;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
import java.util.Set;

@Data
public class CreateDamDto {
    @NotNull
    public int version;
    @NotBlank
    public String context;

    @NotNull
    public Set<ServerInfo> server_info;
    @NotNull
    public Set<Actor> actors;
    @NotNull
    public Set<System> systems;
}
