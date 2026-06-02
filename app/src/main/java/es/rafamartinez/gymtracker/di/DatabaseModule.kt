package es.rafamartinez.gymtracker.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.rafamartinez.gymtracker.data.local.AppDatabase
import es.rafamartinez.gymtracker.data.local.ExerciseDao
import es.rafamartinez.gymtracker.data.local.WeightLogDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = AppDatabase.getDatabase(context)

    @Provides
    fun provideExerciseDao(db: AppDatabase): ExerciseDao = db.exerciseDao()

    @Provides
    fun provideWeightLogDao(db: AppDatabase): WeightLogDao = db.weightLogDao()
}
