package dqualizer.research.dqapi.repositories.old;

import dqualizer.research.dqapi.models.Domain;
import dqualizer.research.dqapi.models.dst.DomainStory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DomainStoryRepository extends MongoRepository<DomainStory, String> {
}
