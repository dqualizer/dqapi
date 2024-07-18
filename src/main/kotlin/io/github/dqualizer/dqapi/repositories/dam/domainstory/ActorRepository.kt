package io.github.dqualizer.dqapi.repositories.dam.domainstory

import io.github.dqualizer.dqlang.types.dam.domainstory.Actor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ActorRepository : MongoRepository<Actor, String>
