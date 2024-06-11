package io.github.dqualizer.dqapi.controllers.dam.domainstory

import io.github.dqualizer.dqapi.services.dam.domainstory.WorkObjectService
import io.github.dqualizer.dqlang.types.dam.domainstory.WorkObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/dam/domain-story/work-object")
class WorkObjectController {
  @Autowired
  lateinit var service: WorkObjectService

  @get:GetMapping
  val all: ResponseEntity<List<WorkObject>>
    get() {
      val workObjects = service.readAll().toList()
      return ResponseEntity(workObjects, HttpStatus.FOUND)
    }

  @GetMapping("/{id}")
  fun getById(@PathVariable id: String): ResponseEntity<WorkObject> {
    val workObject = service.readById(id)
    return ResponseEntity(workObject, HttpStatus.FOUND)
  }

  @PostMapping
  fun create(@RequestBody entity: WorkObject): ResponseEntity<WorkObject> {
    val workObject = service.create(entity)
    return ResponseEntity(workObject, HttpStatus.CREATED)
  }
}
