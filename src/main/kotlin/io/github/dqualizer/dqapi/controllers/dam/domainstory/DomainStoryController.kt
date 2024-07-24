package io.github.dqualizer.dqapi.controllers.dam.domainstory

import io.github.dqualizer.dqapi.services.dam.domainstory.DomainStoryService
import io.github.dqualizer.dqlang.types.dam.domainstory.DomainStory
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v2/domain-story")
class DomainStoryController(
  @Autowired val service: DomainStoryService,
  @Autowired val request: HttpServletRequest
) {
  @GetMapping
  fun readAll(): ResponseEntity<List<DomainStory>> {
    return ResponseEntity.ok(service.readAll())
  }

  @GetMapping("/ids")
  fun readAllIds(): ResponseEntity<List<String>> {
    return ResponseEntity.ok(service.readAllIds())
  }

  @GetMapping("/{id}")
  fun readById(@PathVariable id: String): ResponseEntity<DomainStory> {
    return ResponseEntity.ok(service.readById(id))
  }

  @PostMapping
  fun create(@RequestParam("file") file: MultipartFile): ResponseEntity<DomainStory> {
    val domainStory = service.create(file)

    val location = UriComponentsBuilder.fromUriString(request.requestURI)
      .path("/{id}")
      .buildAndExpand(domainStory.id)
      .toUri()

    return ResponseEntity.created(location).body(domainStory)
  }
}
