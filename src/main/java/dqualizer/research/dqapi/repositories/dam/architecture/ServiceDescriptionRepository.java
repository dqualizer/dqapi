package dqualizer.research.dqapi.repositories.dam.architecture;

import io.github.dqualizer.dqlang.types.dam.architecture.ServiceDescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDescriptionRepository extends MongoRepository<ServiceDescription, String> {
}
