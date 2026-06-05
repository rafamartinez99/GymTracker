package es.rafamartinez.gymtracker.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.rafamartinez.gymtracker.viewmodel.ExerciseViewModel
import es.rafamartinez.gymtracker.viewmodel.WeightLogViewModel

@Composable
fun GymTrackerNavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues,
    exerciseViewModel: ExerciseViewModel,
    weightLogViewModel: WeightLogViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        composable("home") {
            Text("Home - próximamente")
        }
    }
}
