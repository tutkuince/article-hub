package com.incetutku.articlehub.controller.user

import com.incetutku.articlehub.mapper.toModel
import com.incetutku.articlehub.mapper.toResponse
import com.incetutku.articlehub.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping("/api/v1/users")
class UserController(private final val userService: UserService) {

    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): UserResponse =
        userService.createUser(
            user = userRequest.toModel()
        )?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create a user.")

    @GetMapping
    fun listAll(): List<UserResponse> = userService.findAll().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): UserResponse =
        userService.findByUUID(id)?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find a user.")


    @DeleteMapping("/{id}")
    fun deleteByUUID(@PathVariable id: UUID): ResponseEntity<Boolean> {
        val success = userService.deleteByUUID(id)
        return if (success)
            ResponseEntity.noContent().build()
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find a user.")
    }

}