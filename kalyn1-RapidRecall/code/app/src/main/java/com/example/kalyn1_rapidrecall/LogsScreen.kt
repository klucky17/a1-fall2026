package com.example.kalyn1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.String.format
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalLocale

@Composable
fun LogsScreen(
    vm: GameViewModel,
    modifier: Modifier = Modifier
){
    //date and time formatting
    val locale = LocalLocale.current.platformLocale
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", locale)
    val timeFormat = SimpleDateFormat("HH:mm:ss", locale)

    val attempts = vm.summary.attempts.reversed()  //put newest/most recent attempts first/at the top

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Gameplay Log",
            fontSize = 25.sp
        )

        if(attempts.isEmpty()){
            Text(
                text = "No attempts yet",
                modifier = Modifier.padding(top=16.dp)
            )
        }

        LazyColumn(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()){  //list will take over the left over height
            items(attempts){entry ->
                Column(modifier = Modifier.padding(vertical = 8.dp)){
                    Text("Date: ${dateFormat.format(Date(entry.timestamp))}")
                    Text("Time: ${timeFormat.format(Date(entry.timestamp))}")
                    Text("Length: ${entry.length}")
                    Text("Target: ${entry.targetSequence}")
                    Text("Your input: ${entry.userInput}")
                    Text(if (entry.correct) "Correct" else "Incorrect")
                }
                HorizontalDivider()  //seperate each attempt
            }
        }
        Button(
            onClick = {
                vm.goTo(Screen.HOME)  //back to home screen
            }
        ){
            Text("Back")
        }
    }
}