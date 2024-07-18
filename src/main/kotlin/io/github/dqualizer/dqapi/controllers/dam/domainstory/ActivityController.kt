package io.github.dqualizer.dqapi.controllers.dam.domainstory

import io.github.dqualizer.dqapi.services.dam.domainstory.ActivityService
import io.github.dqualizer.dqlang.types.dam.domainstory.Activity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/dam/domain-story/activity")
class ActivityController {
  @Autowired
  lateinit var service: ActivityService

  @get:GetMapping
  val all: ResponseEntity<List<Activity>>
    get() {
      val activities = service.readAll()
      return ResponseEntity(activities, HttpStatus.FOUND)
    }

  @GetMapping("/{id}")
  fun getById(@PathVariable id: String?): ResponseEntity<Activity> {
    val activity = service.readById(id!!)
    return ResponseEntity(activity, HttpStatus.FOUND)
  }

  @PostMapping
  fun create(@RequestBody entity: Activity?): ResponseEntity<Activity> {
    val activity = service.create(entity)
    return ResponseEntity(activity, HttpStatus.CREATED)
  }
}
