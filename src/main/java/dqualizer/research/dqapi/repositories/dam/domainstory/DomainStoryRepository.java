package dqualizer.research.dqapi.repositories.dam.domainstory;

import io.github.dqualizer.dqlang.types.dam.domainstory.DomainStory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DomainStoryRepository extends MongoRepository<DomainStory, String> {
}
