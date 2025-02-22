package com.harshith.news.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.harshith.news.data.local.entities.NewsArticleEntity
import com.harshith.news.model.news.Article
import com.harshith.news.util.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsArticleDao{

    @Insert
    fun addNewsArticles(articles: List<NewsArticleEntity>)

    @Query("SELECT * FROM news_database WHERE myCategory='${Constants.INDIA_NEWS}'")
    fun observerIndiaCategory(): Flow<List<NewsArticleEntity>>

    @Query("SELECT * FROM news_database WHERE myCategory='${Constants.USA_NEWS}'")
    fun observerUsaCategory(): Flow<List<NewsArticleEntity>>

    @Query("SELECT * FROM news_database WHERE uuid=:uuid")
    fun getANewsArticle(uuid: String): NewsArticleEntity

    @Query("SELECT * FROM news_database")
    suspend fun getAllNewsArticles(): List<NewsArticleEntity>

    @Query("DELETE FROM news_database")
    fun deleteAllNews()

    @Query("SELECT COUNT(*) FROM NEWS_DATABASE")
    fun getDatabaseCount(): Int
}