package com.incetutku.articlehub.repository

import com.incetutku.articlehub.model.Article
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ArticleRepository {

    fun findAll(): List<Article> = articles

    private val articles = listOf(
        Article(
            id = UUID.randomUUID(),
            title = "Article - 1",
            content = "Content - 1"
        ),
        Article(
            id = UUID.randomUUID(),
            title = "Article - 2",
            content = "Content - 2"
        ),
        Article(
            id = UUID.randomUUID(),
            title = "Article - 3",
            content = "Content - 3"
        ),
        Article(
            id = UUID.randomUUID(),
            title = "Article - 4",
            content = "Content - 4"
        ),
        Article(
            id = UUID.randomUUID(),
            title = "Article - 5",
            content = "Content - 5"
        )
    )
}