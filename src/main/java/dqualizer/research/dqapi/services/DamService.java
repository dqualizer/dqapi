package dqualizer.research.dqapi.services;

import dqualizer.research.dqapi.dtos.CreateDamDto;
import dqualizer.research.dqapi.models.dam.Actor;
import dqualizer.research.dqapi.models.dam.DomainArchitectureMapping;
import dqualizer.research.dqapi.models.dam.System;
import dqualizer.research.dqapi.repositories.ActorRepository;
import dqualizer.research.dqapi.repositories.DamRepository;
import dqualizer.research.dqapi.repositories.ServerInfoRepository;
import dqualizer.research.dqapi.repositories.SystemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<Actor> actors = new ArrayList<>();
        for (Actor actor: createDamDto.actors
             ) {
            actors.add(actor);
        }

        DomainArchitectureMapping dam = new DomainArchitectureMapping(createDamDto.getVersion(),createDamDto.getContext(), createDamDto.getServer_info(), actors, createDamDto.getSystems());

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
