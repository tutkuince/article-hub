package com.incetutku.articlehub.mapper

import com.incetutku.articlehub.controller.user.UserRequest
import com.incetutku.articlehub.controller.user.UserResponse
import com.incetutku.articlehub.model.Role
import com.incetutku.articlehub.model.User
import java.util.*

fun UserRequest.toModel(): User = User(
    id = UUID.randomUUID(),
    email = this.email,
    password = this.password,
    role = Role.USER
)

fun User.toResponse(): UserResponse = UserResponse(
    uuid = this.id,
    email = this.email
)