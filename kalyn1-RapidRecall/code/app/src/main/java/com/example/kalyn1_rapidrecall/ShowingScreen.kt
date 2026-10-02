package com.example.kalyn1_rapidrecall

/**
Purpose = show the target sequence to remember
Design Rationale =
    1. flash the numbers one by one
Outstanding Issues =
    1. cannot change the speed of the flashing numbers
    2. if want to exit the game, have to wait for all numbers to show and then click back on the next page
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowingScreen(
    modifier: Modifier = Modifier,
    vm: GameViewModel
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = vm.currentNum?.toString() ?: "",  //display current num as a text, if there is no num then display blank
                fontSize = 120.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Lock In!",
            fontSize = 25.sp
        )
    }
}