package com.example.kalyn1_rapidrecall

/**
Purpose = show user if they guessed right or wrong
Design Rationale =
    1. show the target sequence and the inputted player guess
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeedbackScreen(
    vm: GameViewModel,
    modifier: Modifier = Modifier
){
    val attempt = vm.currentAttempt ?: return  //if attempt is null, return -> nothing to show

    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Text(
            text = if(attempt.correct) "Correct!" else "Incorrect :(",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text("Sequence: ${attempt.targetSequence}")
        Text("Your Guess: ${attempt.userInput}")

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                vm.goTo(Screen.HOME)  //back to home screen
            }
        ){
            Text("Back")
        }
    }
}