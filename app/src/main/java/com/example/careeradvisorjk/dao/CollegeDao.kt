package com.example.careeradvisorjk.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.careeradvisorjk.entities.College

@Dao
interface CollegeDao {
    @Query("SELECT * FROM colleges")
    fun getAllColleges(): LiveData<List<College>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(colleges: List<College>)
}