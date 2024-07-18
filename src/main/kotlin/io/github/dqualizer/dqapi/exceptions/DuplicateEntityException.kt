package io.github.dqualizer.dqapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class DuplicateEntityException(message: String?) : RuntimeException(message)
