package dqualizer.research.dqapi.services;

import dqualizer.research.dqapi.dtos.CreateDamDto;
import dqualizer.research.dqapi.models.dam.DomainArchitectureMapping;
import dqualizer.research.dqapi.repositories.ActorRepository;
import dqualizer.research.dqapi.repositories.DamRepository;
import dqualizer.research.dqapi.repositories.ServerInfoRepository;
import dqualizer.research.dqapi.repositories.SystemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        DomainArchitectureMapping dam = new DomainArchitectureMapping(createDamDto.getVersion(),createDamDto.getContext(), createDamDto.getServer_info(), createDamDto.getActors(), createDamDto.getSystems());
        System.out.println(dam.getId());
        actorRepository.insert(createDamDto.getActors());
        systemRepository.insert(createDamDto.getSystems());
        serverInfoRepository.insert(createDamDto.getServer_info());

        return damRepository.insert(dam);
    }
}
