package es.rafamartinez.gymtracker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weight_log")
data class WeightLogEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val exerciseId: Int,
    val weight: Float,
    val reps: Int,
    val date: Long
)
