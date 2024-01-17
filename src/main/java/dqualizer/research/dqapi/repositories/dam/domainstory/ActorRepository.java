package dqualizer.research.dqapi.repositories.dam.domainstory;

import io.github.dqualizer.dqlang.types.dam.domainstory.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends MongoRepository<Actor, String> {

}
