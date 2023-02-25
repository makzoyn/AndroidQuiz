package com.example.androidfirstlab

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private val questionBank = listOf(
        Quiz(R.string.question_it, true),
        Quiz(R.string.question_animals, false),
        Quiz(R.string.question_math, false),
        Quiz(R.string.question_country, true),
        Quiz(R.string.question_oceans, true)
    )
    private var currentIndex = 0

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev(){
        currentIndex = (questionBank.size+currentIndex - 1) % questionBank.size
    }
}