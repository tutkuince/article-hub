package com.incetutku.articlehub.service

import com.incetutku.articlehub.model.User
import com.incetutku.articlehub.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private final val userRepository: UserRepository) {
    fun createUser(user: User): User? {
        val found = userRepository.findByEmail(user.email)

        return if (found == null) {
            userRepository.save(user)
            user
        } else null
    }

    fun findByUUID(uuid: UUID): User? = userRepository.findByUUID(uuid)
    fun findAll(): List<User> = userRepository.findAll()
    fun deleteByUUID(uuid: UUID): Boolean = userRepository.deleteByUUID(uuid)
}