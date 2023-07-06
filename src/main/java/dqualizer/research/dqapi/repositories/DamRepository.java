package dqualizer.research.dqapi.repositories;


import dqualizer.research.dqapi.models.dam.DomainArchitectureMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DamRepository extends MongoRepository<DomainArchitectureMapping, String> {

}
