package com.example.kalyn1_rapidrecall

/**
Purpose = game log variables
Design Rationale =
    1. create data class log
 */

data class Log(
    val length: Int,
    val userInput: String,
    val targetSequence: String,
    val correct: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)