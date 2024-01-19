package io.github.dqualizer.dqapi.repositories.old;


import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DamRepository extends MongoRepository<DomainArchitectureMapping, String> {

}
