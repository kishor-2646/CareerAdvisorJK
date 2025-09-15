package com.example.careeradvisorjk.respository

import androidx.lifecycle.LiveData
import com.example.careeradvisorjk.dao.CollegeDao
import com.example.careeradvisorjk.entities.College

class CollegeRepository(private val collegeDao: CollegeDao) {
    val allColleges: LiveData<List<College>> = collegeDao.getAllColleges()

    suspend fun insertAll(colleges: List<College>) {
        collegeDao.insertAll(colleges)
    }
}