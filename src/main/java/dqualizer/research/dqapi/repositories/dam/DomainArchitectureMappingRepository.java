package dqualizer.research.dqapi.repositories.dam;

import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainArchitectureMappingRepository extends MongoRepository<DomainArchitectureMapping, String> {
}
