package dqualizer.research.dqapi.services;

import dqualizer.research.dqapi.dtos.CreateDamDto;


import dqualizer.research.dqapi.repositories.ActorRepository;
import dqualizer.research.dqapi.repositories.DamRepository;
import dqualizer.research.dqapi.repositories.ServerInfoRepository;
import dqualizer.research.dqapi.repositories.SystemRepository;
import io.github.dqualizer.dqlang.types.dam.Actor;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DamService {
    private final DamRepository damRepository;
    private final ActorRepository actorRepository;
    private final SystemRepository systemRepository;
    private final ServerInfoRepository serverInfoRepository;


    public List<DomainArchitectureMapping> getAllDams() {
        return damRepository.findAll();
    }

    public DomainArchitectureMapping createNewDam(CreateDamDto createDamDto) {
        Set<Actor> actors = new HashSet<>();
        for (Actor actor: createDamDto.actors
             ) {
            actors.add(actor);
        }

        DomainArchitectureMapping dam = new DomainArchitectureMapping();
        dam.setVersion(createDamDto.getVersion());
        dam.setContext(createDamDto.getContext());
        dam.setServerInfos(createDamDto.getServer_info());
        dam.setActors(actors);
        dam.setSystems(createDamDto.getSystems());

        return damRepository.insert(dam);
    }

    public List<DomainArchitectureMapping> deleteAllDams() {
        damRepository.deleteAll();
        return new ArrayList<>();
    }

    public DomainArchitectureMapping getDamById(String id) {
        return damRepository.findById(id).orElseThrow(() ->new IllegalStateException("Domain with id + " + id + "not found!"));
    }
}
