package com.incetutku.articlehub.controller.article

import com.incetutku.articlehub.mapper.toResponse
import com.incetutku.articlehub.response.ArticleResponse
import com.incetutku.articlehub.service.ArticleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(
    private val articleService: ArticleService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<ArticleResponse>> = ResponseEntity(
        articleService.findAll().map { it.toResponse() },
        HttpStatus.OK
    )
}