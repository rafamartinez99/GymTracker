package es.rafamartinez.gymtracker.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.rafamartinez.gymtracker.ui.components.ExerciseCard
import es.rafamartinez.gymtracker.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(exerciseViewModel: ExerciseViewModel, navController: NavController) {
    val exercises by exerciseViewModel.exercises.collectAsState()
    val groupedExercises = exercises.groupBy { it.category }

    if (exercises.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            TopAppBar(title = {
                Text("GymTracker", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            })
        }

        groupedExercises.forEach { (category, exercisesInCategory) ->
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = category,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
            items(exercisesInCategory) { exercise ->
                ExerciseCard(exercise = exercise) {
                    navController.navigate("exercise_detail/${exercise.id}")
                }
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }
    }
}
