package com.harshith.news.util

import com.harshith.news.data.local.entities.NewsArticleEntity
import com.harshith.news.data.local.entities.NewsSourceEntity
import com.harshith.news.data.network.model.NetworkNewsArticle
import com.harshith.news.data.network.model.NetworkNewsSource
import com.harshith.news.model.news.Article
import com.harshith.news.model.news.Source

fun NetworkNewsArticle.toNewsArticleEntity(category: String): NewsArticleEntity{
    return NewsArticleEntity(
        myCategory = category,
        author = this.author,
        content = this.content,
        description = this.description,
        publishedAt = this.publishedAt,
        source = this.source.toNewsSourceEntity(),
        title = this.title,
        url = this.url,
        urlToImage = this.urlToImage
    )
}

fun NetworkNewsSource.toNewsSourceEntity(): NewsSourceEntity{
    return NewsSourceEntity(
        id = this.id,
        name = this.name
    )
}

fun NewsArticleEntity.toNewsArticle(): Article{
    return Article(
        uuid = this.uuid,
        author = this.author,
        category = this.myCategory,
        content = this.content,
        description = this.description,
        publishedAt = this.publishedAt,
        source = this.source!!.toNewSource(),
        title = this.title,
        url = this.url,
        urlToImage = this.urlToImage
    )
}

fun NewsSourceEntity.toNewSource(): Source{
    return Source(
        id = this.id,
        name = this.name
    )
}