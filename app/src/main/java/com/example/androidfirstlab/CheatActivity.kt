package com.example.androidfirstlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class CheatActivity : AppCompatActivity() {
    private var answer = false
    private lateinit var answerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        answer= intent?.getBooleanExtra("answer", false)?:false
        setContentView(R.layout.activity_cheat)
        answerTextView = findViewById(R.id.cheat_text)
        answerTextView.visibility = View.GONE
        findViewById<Button>(R.id.button_cheat).setOnClickListener {
            showAnswerDialog()
        }
    }
    private fun showAnswer()
    {
        answerTextView.visibility = View.VISIBLE
        answerTextView.text = when{
            answer == true -> "True"
            else -> "False"
        }
    }
    private fun showAnswerDialog(){
        AlertDialog.Builder(this)
            .setTitle("Cheating is bad!")
            .setMessage("Are u sure?")
            .setPositiveButton("YES"){ _, _ ->
                showAnswer()
            }
            .setNegativeButton("NO", null)
            .setCancelable(true)
            .create()
            .show()
    }
}