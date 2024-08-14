package io.github.dqualizer.dqapi.models.domainstory

import io.github.dqualizer.dqlang.types.dam.domainstory.Activity
import io.github.dqualizer.dqlang.types.dam.domainstory.Actor
import io.github.dqualizer.dqlang.types.dam.domainstory.DomainStory
import io.github.dqualizer.dqlang.types.dam.domainstory.WorkObject
import java.io.File

data class CreateDomainStoryDto(
  val actors: List<Actor>,
  val workObjects: List<WorkObject>,
  val activities: List<Activity>,
) {
  companion object {
    fun ofDST(file: File): CreateDomainStoryDto {
      TODO("implement")
      val actors = emptyList<Actor>()
      val workObjects = emptyList<WorkObject>()
      val activities = emptyList<Activity>()
      return CreateDomainStoryDto(
        actors, workObjects, activities,
      )
    }

    fun ofEGN(file: File): CreateDomainStoryDto {
      TODO("implement")
      val actors = emptyList<Actor>()
      val workObjects = emptyList<WorkObject>()
      val activities = emptyList<Activity>()
      return CreateDomainStoryDto(
        actors, workObjects, activities,
      )
    }
  }

  fun build(): DomainStory {
    val actors = emptyList<Actor>()
    val workObjects = emptyList<WorkObject>()
    val activities = emptyList<Activity>()
    return DomainStory(
      actors, workObjects, activities,
    )
  }
}
