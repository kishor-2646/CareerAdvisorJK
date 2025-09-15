package com.example.careeradvisorjk


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.careeradvisorjk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NO .replace() code is needed here!
        // The NavHostFragment in the XML does all the work automatically.
    }
}