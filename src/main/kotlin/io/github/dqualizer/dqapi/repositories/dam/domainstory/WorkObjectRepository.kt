package io.github.dqualizer.dqapi.repositories.dam.domainstory

import io.github.dqualizer.dqlang.types.dam.domainstory.WorkObject
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkObjectRepository : MongoRepository<WorkObject, String>
