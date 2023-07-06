package dqualizer.research.dqapi.repositories;

import dqualizer.research.dqapi.models.dam.ServerInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerInfoRepository extends MongoRepository<ServerInfo, String> {
}
