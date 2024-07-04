package com.incetutku.articlehub.response

import java.util.UUID

data class ArticleResponse(
    val id: UUID,
    var title: String,
    var content: String
)
