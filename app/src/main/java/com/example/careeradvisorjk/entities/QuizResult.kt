package com.example.careeradvisorjk.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_results")
data class QuizResult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val answers: String,              // e.g. "0,1,2,0,1"
    val recommendedStreams: String,   // e.g. "Science,Technology"
    val timestamp: Long = System.currentTimeMillis()
)