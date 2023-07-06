package dqualizer.research.dqapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import dqualizer.research.dqapi.models.dam.System;
public interface SystemRepository extends MongoRepository<System, String> {
}
