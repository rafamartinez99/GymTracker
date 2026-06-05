package es.rafamartinez.gymtracker.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import es.rafamartinez.gymtracker.ui.navigation.GymTrackerNavGraph
import es.rafamartinez.gymtracker.viewmodel.ExerciseViewModel
import es.rafamartinez.gymtracker.viewmodel.WeightLogViewModel

@Composable
fun GymTrackerApp(navController: NavHostController = rememberNavController()) {
    val exerciseViewModel: ExerciseViewModel = hiltViewModel()
    val weightLogViewModel: WeightLogViewModel = hiltViewModel()

    Scaffold { innerPadding ->
        GymTrackerNavGraph(
            navController = navController,
            innerPadding = innerPadding,
            exerciseViewModel = exerciseViewModel,
            weightLogViewModel = weightLogViewModel
        )
    }
}
