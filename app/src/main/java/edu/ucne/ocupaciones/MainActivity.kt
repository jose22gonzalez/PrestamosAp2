package edu.ucne.ocupaciones

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.ucne.ocupaciones.ui.theme.OcupacionesTheme
import  androidx.compose.runtime.*
import androidx.compose.ui.unit.TextUnit
import kotlinx.coroutines.launch
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.ocupaciones.ui.Occupation_list.OccupationListScreen
import edu.ucne.ocupaciones.ui.Ocupacion.OccupationScreen
import edu.ucne.ocupaciones.util.Screen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.internal.GeneratedComponent
import dagger.hilt.internal.GeneratedComponentManager
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OcupacionesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.OccupationListScreen.route
                        ) {
                        composable(Screen.OccupationListScreen.route) {
                            OccupationListScreen(
                                onClick = {navController.navigate(Screen.OccupationScreen.route)}
                            )
                        }
                        composable(Screen.OccupationScreen.route){
                           OccupationScreen({ navController.navigateUp()})
                        }

                    }
                }
            }
        }
    }
}

