package es.rafamartinez.gymtracker.data.repository

import es.rafamartinez.gymtracker.data.local.WeightLogDao
import es.rafamartinez.gymtracker.data.local.WeightLogEntity
import javax.inject.Inject

class WeightLogRepository @Inject constructor(
    private val weightLogDao: WeightLogDao
) {
    fun getWeightLogsByExercise(exerciseId: Int) = weightLogDao.getWeightLogsByExercise(exerciseId)

    fun getMaxWeight(exerciseId: Int) = weightLogDao.getMaxWeight(exerciseId)

    suspend fun insertWeightLog(weightLog: WeightLogEntity) =
        weightLogDao.insertWeight(listOf(weightLog))
}
