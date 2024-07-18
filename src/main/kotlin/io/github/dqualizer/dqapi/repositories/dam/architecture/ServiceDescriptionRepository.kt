package io.github.dqualizer.dqapi.repositories.dam.architecture

import io.github.dqualizer.dqlang.data.ServicesMongoRepository
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository

@Repository
@Primary
interface ServiceDescriptionRepository : ServicesMongoRepository
