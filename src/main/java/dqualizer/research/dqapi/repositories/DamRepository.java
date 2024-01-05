package dqualizer.research.dqapi.repositories;


import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DamRepository extends MongoRepository<DomainArchitectureMapping, String> {

}
