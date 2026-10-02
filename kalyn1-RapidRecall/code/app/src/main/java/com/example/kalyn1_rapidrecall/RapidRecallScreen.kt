package com.example.kalyn1_rapidrecall

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun RapidRecallScreen(
    modifier: Modifier = Modifier,
    vm: GameViewModel
){
    var sequenceLen by remember {mutableStateOf("")}
    val length = sequenceLen.toIntOrNull()  //change from string to int
    val isValid = length != null && length in 1..10//check if length is valid and 1-10

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Rapid Recall",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedTextField(
                value = sequenceLen,
                onValueChange = {sequenceLen = it.filter(Char::isDigit).take(2)},  //can enter max 2 numbers
                label = {Text("Enter a number 1-10")},
                singleLine = true,  //check that there is only on line
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),  //check if the input is a number
                isError = sequenceLen.isNotEmpty() && !isValid,  //error if there is an input but it is not valid
                modifier = Modifier.width(200.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                enabled = isValid,
                onClick = {
                    vm.startGame(length!!)
                }
            ){
                Text("Start Game")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    vm.goTo(Screen.SUMMARY)
                }
            ){
                Text("Gameplay Summary")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    vm.goTo(Screen.LOG)
                }
            ){
                Text("Gameplay Log")
            }
        }
    }
}