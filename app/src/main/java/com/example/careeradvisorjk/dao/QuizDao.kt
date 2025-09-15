package com.example.careeradvisorjk.dao

import androidx.room.*
import com.example.careeradvisorjk.entities.QuizResult

@Dao
interface QuizDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizResult(result: QuizResult)
}