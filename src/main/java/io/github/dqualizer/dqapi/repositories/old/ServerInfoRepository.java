package io.github.dqualizer.dqapi.repositories.old;


import io.github.dqualizer.dqlang.types.dam.ServerInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerInfoRepository extends MongoRepository<ServerInfo, String> {
}
