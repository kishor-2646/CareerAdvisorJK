package com.example.careeradvisorjk.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.careeradvisorjk.dao.CollegeDao
import com.example.careeradvisorjk.dao.QuizDao
import com.example.careeradvisorjk.entities.College
import com.example.careeradvisorjk.entities.QuizResult

@Database(entities = [College::class, QuizResult::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun collegeDao(): CollegeDao
    abstract fun quizDao(): QuizDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "career_advisor_database"
                )
                    .allowMainThreadQueries() // only for testing/prototype
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}