package io.github.dqualizer.dqapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler {
  @ExceptionHandler(NotFoundException::class)
  fun handleNotFoundException(ex: NotFoundException): ResponseEntity<*> {
    return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
  }

  @ExceptionHandler(DuplicateEntityException::class)
  fun handleDuplicateKeyException(ex: DuplicateEntityException): ResponseEntity<*> {
    val error = ErrorResponse.create(
      ex, HttpStatus.CONFLICT,
      ex.message!!
    )
    return ResponseEntity(error, HttpStatus.CONFLICT)
  }
}
