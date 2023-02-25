package com.example.androidfirstlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var btnTrue : Button
    private lateinit var btnFalse : Button
    private lateinit var nextBtn : ImageButton
    private lateinit var prevBtn : ImageButton
    private lateinit var questionTextView: TextView

    private val quizViewModel: MainActivityViewModel by lazy {
        val provider = ViewModelProvider(this)
        provider.get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFalse = findViewById(R.id.denyBtn)
        btnTrue = findViewById(R.id.allowBtn)
        nextBtn = findViewById(R.id.next_button)
        prevBtn = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.questionText)

        btnTrue.setOnClickListener {
            checkAnswer(true)
        }
        btnFalse.setOnClickListener {
            checkAnswer(false)
        }
        nextBtn.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }
        prevBtn.setOnClickListener {
            quizViewModel.moveToPrev()
            updateQuestion()
        }

        findViewById<Button>(R.id.button_answer).setOnClickListener {
            val intent = Intent(this, CheatActivity::class.java)
            intent.putExtra("answer", quizViewModel.currentQuestionAnswer)
            startActivity(intent)
        }
        updateQuestion()

    }
    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer

        val messageResId = when{
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show()
    }

    private fun updateQuestion(){
        val questionTextResId = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }

}