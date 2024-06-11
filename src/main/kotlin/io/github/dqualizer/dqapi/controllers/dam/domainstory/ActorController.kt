package io.github.dqualizer.dqapi.controllers.dam.domainstory

import io.github.dqualizer.dqapi.services.dam.domainstory.ActorService
import io.github.dqualizer.dqlang.types.dam.domainstory.Actor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/dam/domain-story/actor")
class ActorController {
  @Autowired
  lateinit var service: ActorService

  @get:GetMapping
  val all: ResponseEntity<List<Actor>>
    get() {
      val actors = service.readAll()
      return ResponseEntity(actors, HttpStatus.FOUND)
    }

  @GetMapping("/{id}")
  fun getById(@PathVariable id: String?): ResponseEntity<Actor> {
    val actor = service.readById(id!!)
    return ResponseEntity(actor, HttpStatus.FOUND)
  }

  @PostMapping
  fun create(@RequestBody entity: Actor?): ResponseEntity<Actor> {
    val actor = service.create(entity)
    return ResponseEntity(actor, HttpStatus.CREATED)
  }
}
