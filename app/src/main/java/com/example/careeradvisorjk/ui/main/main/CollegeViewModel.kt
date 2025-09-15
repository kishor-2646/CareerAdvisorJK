package com.example.careeradvisorjk.ui.main.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.careeradvisorjk.database.AppDatabase
import com.example.careeradvisorjk.entities.College
import com.example.careeradvisorjk.respository.CollegeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CollegeViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: CollegeRepository
    val colleges: LiveData<List<College>>

    init {
        val db = AppDatabase.getDatabase(application)
        repo = CollegeRepository(db.collegeDao())
        colleges = repo.allColleges
    }

    fun insertAll(list: List<College>) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertAll(list)
        }
    }
}