package com.example.kalyn1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuessingScreen(
    modifier: Modifier = Modifier,
    vm: GameViewModel
){
    var playerGuess by remember {mutableStateOf("")}
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        //how to input the sequence numbers
        Text("Input number sequence in order with no spaces")
        Text("ie. 123")

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sequence length: ${vm.sequenceLength}"  //show user how many numbers to guess
        )

        OutlinedTextField(
            value = playerGuess,
            onValueChange = {playerGuess = it.filter(Char::isDigit).take(vm.sequenceLength)},  //max num can input is sequenceLength
            label = {Text("Enter sequence")},
            singleLine = true,  //check that there is only on line
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),  //can only input a number
            modifier = Modifier.width(200.dp)
        )

        Button(
            enabled = playerGuess.length == vm.sequenceLength,  //can only guess if input length = sequence length
            onClick = {
                vm.Guess(playerGuess)
                vm.goTo(Screen.FEEDBACK)  //show feedback
            }
        ){
            Text("Guess")
        }
    }
}