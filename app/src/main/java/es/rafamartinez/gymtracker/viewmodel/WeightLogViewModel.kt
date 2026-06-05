package es.rafamartinez.gymtracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.rafamartinez.gymtracker.data.local.WeightLogEntity
import es.rafamartinez.gymtracker.data.repository.WeightLogRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightLogViewModel @Inject constructor(
    private val repository: WeightLogRepository
) : ViewModel() {

    fun getWeightLogs(exerciseId: Int): StateFlow<List<WeightLogEntity>> =
        repository.getWeightLogsByExercise(exerciseId)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun getMaxWeight(exerciseId: Int): StateFlow<Float?> =
        repository.getMaxWeight(exerciseId)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun insertWeightLog(weightLog: WeightLogEntity) {
        viewModelScope.launch {
            repository.insertWeightLog(weightLog)
        }
    }
}
