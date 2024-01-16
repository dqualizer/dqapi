package dqualizer.research.dqapi.repositories.old;


import io.github.dqualizer.dqlang.types.dam.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActorRepository extends MongoRepository<Actor, String> {
}
