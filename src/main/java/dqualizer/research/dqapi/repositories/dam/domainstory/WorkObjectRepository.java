package dqualizer.research.dqapi.repositories.dam.domainstory;

import io.github.dqualizer.dqlang.types.dam.domainstory.WorkObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkObjectRepository extends MongoRepository<WorkObject, String> {
}
