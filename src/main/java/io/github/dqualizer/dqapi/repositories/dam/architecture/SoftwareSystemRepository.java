package io.github.dqualizer.dqapi.repositories.dam.architecture;

import io.github.dqualizer.dqlang.types.dam.architecture.SoftwareSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SoftwareSystemRepository extends MongoRepository<SoftwareSystem, String> { }
