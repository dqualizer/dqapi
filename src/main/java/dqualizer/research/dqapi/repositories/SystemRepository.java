package dqualizer.research.dqapi.repositories;

import io.github.dqualizer.dqlang.types.dam.System;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SystemRepository extends MongoRepository<System, String> {
}
