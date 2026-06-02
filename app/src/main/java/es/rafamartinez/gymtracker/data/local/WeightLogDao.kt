package es.rafamartinez.gymtracker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeightLogDao {
    @Query("SELECT * FROM weight_log WHERE exerciseId = :exerciseId ORDER BY date DESC")
    fun getWeightLogsByExercise(exerciseId: Int): Flow<List<WeightLogEntity>>

    @Query("SELECT MAX(weight) FROM weight_log WHERE exerciseId = :exerciseId")
    fun getMaxWeight(exerciseId: Int): Flow<Float?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeight(weight: List<WeightLogEntity>)

}
