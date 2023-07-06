package dqualizer.research.dqapi.repositories;

import dqualizer.research.dqapi.models.dam.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActorRepository extends MongoRepository<Actor, String> {
}
