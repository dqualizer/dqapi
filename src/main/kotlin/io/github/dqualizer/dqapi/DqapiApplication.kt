package io.github.dqualizer.dqapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories
@SpringBootApplication
class DqapiApplication

fun main(args: Array<String>) {
  runApplication<DqapiApplication>(*args)
}
