package com.example.kalyn1_rapidrecall

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class Screen{
    HOME,
    SHOWING,
    GUESS,
    FEEDBACK,
    LOG,
    SUMMARY,
}

class GameViewModel : ViewModel(){

    val sequenceLength: Int get() = sequence.size
    var screen by mutableStateOf(Screen.HOME)  //home/starting screen
        private set
    var currentNum by mutableStateOf<Int?>(null)  //no number showing yet
        private set
    private var sequence: List<Int> = emptyList()
    val summary = Summary()
    var currentAttempt by mutableStateOf<Log?>(null)
        private set

    fun goTo(s: Screen){
        screen = s
    }

    fun startGame(length: Int){
        sequence = List(length){(0..9).random()}  //get random sequence w numbers 0-9
        screen = Screen.SHOWING  //showing the seqeunce to memorize

        viewModelScope.launch{
            for(num in sequence){
                currentNum = num  //show the number
                delay(800)  //number is displayed for 0.8 secs
                currentNum = null  //hide number
                delay(300)  //number is hidden for 0.3 secs
            }
            screen = Screen.GUESS  //get user input guess
        }
    }

    fun Guess(guess: String){
        val target = sequence.joinToString("")  //change the sequence from a list to a string to match the user input
        val entry = Log(
            length = sequence.size,
            userInput = guess,
            targetSequence = target,
            correct = guess==target
        )
        summary.add(entry)  //add to summary data
        currentAttempt = entry  //update current attempt
        screen = Screen.FEEDBACK  //show player if the quess was right or not
    }
}
