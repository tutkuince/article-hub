package com.incetutku.articlehub.service

import com.incetutku.articlehub.model.Article
import com.incetutku.articlehub.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {
    fun findAll(): List<Article> = articleRepository.findAll()
}