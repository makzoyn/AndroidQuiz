package com.example.androidfirstlab

import androidx.annotation.StringRes

data class Quiz(@StringRes val textResId: Int, val answer: Boolean)
