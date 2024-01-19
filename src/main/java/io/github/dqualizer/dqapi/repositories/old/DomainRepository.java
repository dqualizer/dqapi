package io.github.dqualizer.dqapi.repositories.old;

import dqualizer.research.dqapi.models.Domain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DomainRepository extends MongoRepository<Domain, String> {
    Optional<Domain> findByName(String domainName);
}
