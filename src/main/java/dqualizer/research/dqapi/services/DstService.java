package dqualizer.research.dqapi.services;

import dqualizer.research.dqapi.dtos.CreateDstDto;
import dqualizer.research.dqapi.models.context.Context;
import dqualizer.research.dqapi.models.dst.DomainStory;
import dqualizer.research.dqapi.repositories.DomainRepository;
import dqualizer.research.dqapi.repositories.DomainStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DstService {
    private final DomainStoryRepository domainStoryRepository;
    private final DomainRepository domainRepository;
    public DomainStory createNewDst(CreateDstDto createDstDto) {
        return null;
    }

    public List<DomainStory> getAllDsts() {
        return domainStoryRepository.findAll();
    }
}
