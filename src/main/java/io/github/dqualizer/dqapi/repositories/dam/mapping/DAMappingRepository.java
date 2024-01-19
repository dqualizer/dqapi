package io.github.dqualizer.dqapi.repositories.dam.mapping;

import io.github.dqualizer.dqlang.types.dam.mapping.DAMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DAMappingRepository extends MongoRepository<DAMapping, String> {
}

