package io.github.dqualizer.dqapi.repositories.old;

import io.github.dqualizer.dqlang.types.dam.System;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SystemRepository extends MongoRepository<System, String> {
}
