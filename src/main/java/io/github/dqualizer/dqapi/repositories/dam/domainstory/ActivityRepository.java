package io.github.dqualizer.dqapi.repositories.dam.domainstory;

import io.github.dqualizer.dqlang.types.dam.domainstory.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityRepository extends MongoRepository<Activity, String> {
}
