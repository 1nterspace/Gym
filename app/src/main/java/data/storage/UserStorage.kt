package data.storage

import domain.models.ExerciseStatItem
import domain.models.ExerciseTypeItem
import domain.models.MuscleTypeItem

interface UserStorage {

    suspend fun getMuscleMenu(): List<MuscleTypeItem>

    suspend fun getExerciseMenu(muscleName: String): List<ExerciseTypeItem>

    fun saveExerciseStats(exerciseStatItem: ExerciseStatItem)

    fun getExerciseStats(exerciseName: String): List<ExerciseStatItem>

}