package edu.ucne.ocupaciones


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import edu.ucne.ocupaciones.ui.theme.OcupacionesTheme
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.ocupaciones.ui.Occupation_list.OccupationListScreen
import edu.ucne.ocupaciones.ui.Ocupacion.OccupationScreen
import edu.ucne.ocupaciones.util.Screen
import dagger.hilt.android.AndroidEntryPoint

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

