package com.example.kalyn1_rapidrecall

/**
Purpose = main activity, handles screen changes
Design Rationale =
    1. when the enum screen class is called, the coresponding screen file is called
Outstanding Issues = empty else bracket
*/

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kalyn1_rapidrecall.ui.theme.Kalyn1RapidRecallTheme

class MainActivity : ComponentActivity() {
    private val vm: GameViewModel by viewModels()  //keeps game data alive if activity needs to be recreated

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kalyn1RapidRecallTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val modifier = Modifier.padding(innerPadding)
                    when(vm.screen){
                        Screen.HOME -> RapidRecallScreen(vm = vm, modifier = modifier)
                        Screen.SHOWING -> ShowingScreen(vm = vm, modifier = modifier)
                        Screen.GUESS -> GuessingScreen(vm = vm, modifier = modifier)
                        Screen.FEEDBACK -> FeedbackScreen(vm = vm, modifier = modifier)
                        Screen.LOG -> LogsScreen(vm = vm, modifier = modifier)
                        Screen.SUMMARY -> SummaryScreen(vm = vm, modifier = modifier)
                        else -> {}
                    }
                }
            }
        }
    }
}