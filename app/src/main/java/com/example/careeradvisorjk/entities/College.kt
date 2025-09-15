package com.example.careeradvisorjk.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colleges")
data class College(
    @PrimaryKey val id: Int,
    val name: String,
    val district: String,
    val courses: String,     // stored as comma-separated values
    val facilities: String   // stored as comma-separated values
)