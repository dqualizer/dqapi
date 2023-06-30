package dqualizer.research.dqapi.repositories;

import dqualizer.research.dqapi.models.rqa.RqaDefinition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RqaDefinitionRepository extends MongoRepository<RqaDefinition, String> {

    Optional<RqaDefinition> findByName(String name);
}
