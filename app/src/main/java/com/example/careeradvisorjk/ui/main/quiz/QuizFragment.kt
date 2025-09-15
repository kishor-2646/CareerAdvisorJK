package com.example.careeradvisorjk.ui.main.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.careeradvisorjk.R
import androidx.navigation.fragment.findNavController

import com.example.careeradvisorjk.ui.main.quiz.QuizData
import com.example.careeradvisorjk.databinding.FragmentQuizBinding
import androidx.navigation.fragment.findNavController


class QuizFragment : Fragment() {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private var currentQuestionIndex = 0
    private val userAnswers = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayCurrentQuestion()
        binding.nextButton.setOnClickListener { handleNextButtonClick() }
    }

    private fun displayCurrentQuestion() {
        val question = QuizData.questions[currentQuestionIndex]
        binding.progressText.text = "Question ${currentQuestionIndex + 1} of ${QuizData.questions.size}"
        binding.questionText.text = question.text
        binding.optionsGroup.removeAllViews()
        question.options.forEachIndexed { index, optionText ->
            val radioButton = RadioButton(requireContext()).apply {
                text = optionText
                id = index
                textSize = 16f
                setPadding(16, 16, 16, 16)
            }
            binding.optionsGroup.addView(radioButton)
        }
    }

    private fun handleNextButtonClick() {
        val selectedOptionId = binding.optionsGroup.checkedRadioButtonId
        if (selectedOptionId == -1) {
            Toast.makeText(requireContext(), "Please select an option", Toast.LENGTH_SHORT).show()
            return
        }
        userAnswers.add(selectedOptionId)
        if (currentQuestionIndex < QuizData.questions.size - 1) {
            currentQuestionIndex++
            displayCurrentQuestion()
        } else {
            processResults()
        }
    }

    private fun processResults() {
        val scienceScore = userAnswers.count { it == 0 }
        val commerceScore = userAnswers.count { it == 1 }
        val artsScore = userAnswers.count { it == 2 }
        val humanitiesScore = userAnswers.count { it == 3 }
        val scores = mapOf(
            "Science" to scienceScore, "Commerce" to commerceScore,
            "Arts" to artsScore, "Humanities" to humanitiesScore
        )
        val recommendations = scores.entries
            .sortedByDescending { it.value }
            .take(2)
            .map { it.key }
        Toast.makeText(requireContext(),
            "Recommended: ${recommendations.joinToString()}",
            Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_quizFragment_to_collegeDirectoryFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}