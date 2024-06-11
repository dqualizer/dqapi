package io.github.dqualizer.dqapi.repositories.dam

import io.github.dqualizer.dqlang.data.DAMMongoRepository
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository

@Repository
@Primary
interface DomainArchitectureMappingRepository : DAMMongoRepository
