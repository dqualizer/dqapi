package dqualizer.research.dqapi.services.old;

import dqualizer.research.dqapi.dtos.old.CreateDstDto;
import dqualizer.research.dqapi.models.dst.DomainStory;
import dqualizer.research.dqapi.repositories.old.DomainRepository;
import dqualizer.research.dqapi.repositories.old.DomainStoryRepository;
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
