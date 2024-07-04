package com.incetutku.articlehub.mapper

import com.incetutku.articlehub.model.Article
import com.incetutku.articlehub.response.ArticleResponse

fun Article.toResponse(): ArticleResponse = ArticleResponse(
    id = this.id,
    title = this.title,
    content = this.content
)