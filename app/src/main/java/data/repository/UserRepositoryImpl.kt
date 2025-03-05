package data.repository

import android.util.Log
import data.storage.UserStorage
import domain.models.ExerciseStatItem
import domain.models.ExerciseTypeItem
import domain.models.MuscleTypeItem
import domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override suspend fun getMuscleMenu(): List<MuscleTypeItem> {
        Log.d("FixRoad", "UserRepositoryIml Create")
        return userStorage.getMuscleMenu()
    }

    override suspend fun getExerciseMenu(muscleName: String): List<ExerciseTypeItem> {
        return userStorage.getExerciseMenu(muscleName)
    }

    override fun saveExerciseStats(exerciseStatItem: ExerciseStatItem) {
        return userStorage.saveExerciseStats(exerciseStatItem)
    }

    override fun getExerciseStats(exerciseName: String): List<ExerciseStatItem> {
        return userStorage.getExerciseStats(exerciseName)
    }

}