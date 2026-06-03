package es.rafamartinez.gymtracker.data.repository

import es.rafamartinez.gymtracker.data.local.ExerciseDao
import es.rafamartinez.gymtracker.data.local.ExerciseEntity
import javax.inject.Inject

class ExerciseRepository @Inject constructor(
    private val exerciseDao: ExerciseDao
) {
    fun getAllExercises() = exerciseDao.getAllExercises()

    fun getExercisesByCategory(category: String) = exerciseDao.getExerciseByCategory(category)

    suspend fun initExercisesIfNeeded(exercises: List<ExerciseEntity>) {
        if (exerciseDao.getExerciseCount() == 0) {
            exerciseDao.insertExercise(exercises)
        }
    }
}