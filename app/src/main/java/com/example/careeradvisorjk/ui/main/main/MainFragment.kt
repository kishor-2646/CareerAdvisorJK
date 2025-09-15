package com.example.careeradvisorjk.ui.main.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.careeradvisorjk.R
import com.example.careeradvisorjk.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    // This is the nullable backing property
    private var _binding: FragmentMainBinding? = null

    // This is the non-nullable property for easy access.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // You must assign to the nullable _binding property here
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startQuizButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_quizFragment)
        }
    }

    // This is important to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
