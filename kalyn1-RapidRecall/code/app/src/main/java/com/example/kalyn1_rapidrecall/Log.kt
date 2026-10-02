package com.example.kalyn1_rapidrecall

data class Log(
    val length: Int,
    val userInput: String,
    val targetSequence: String,
    val correct: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)