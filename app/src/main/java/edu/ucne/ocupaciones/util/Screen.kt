package edu.ucne.ocupaciones.util

sealed class Screen (val route: String) {
    object OccupationListScreen: Screen("OccupationList")
    object OccupationScreen: Screen("OccupationScreen")
}