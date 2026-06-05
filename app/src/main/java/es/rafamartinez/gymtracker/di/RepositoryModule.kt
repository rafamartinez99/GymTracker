package es.rafamartinez.gymtracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.rafamartinez.gymtracker.data.local.ExerciseDao
import es.rafamartinez.gymtracker.data.local.WeightLogDao
import es.rafamartinez.gymtracker.data.repository.ExerciseRepository
import es.rafamartinez.gymtracker.data.repository.WeightLogRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideExerciseRepository(exerciseDao: ExerciseDao): ExerciseRepository =
        ExerciseRepository(exerciseDao)

    @Provides
    @Singleton
    fun provideWeightLogRepository(weightLogDao: WeightLogDao): WeightLogRepository =
        WeightLogRepository(weightLogDao)
}
