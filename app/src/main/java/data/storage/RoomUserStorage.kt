package data.storage

import android.content.Context
import android.util.Log
import data.storage.ExerciseDB.ExerciseTypeDb
import data.storage.ExerciseStatsDB.ExerciseStatsDb
import data.storage.MuscleDB.MuscleTypeDb
import domain.models.ExerciseStatItem
import domain.models.ExerciseTypeItem
import domain.models.MuscleTypeItem

class RoomUserStorage(context: Context):UserStorage {

    val muscleTypeDb = MuscleTypeDb.getMuscleTypeDb(context)
    val exerciseTypeDb = ExerciseTypeDb.getExerciseTypeDb(context)
    val exerciseStatsDb = ExerciseStatsDb.getExerciseStatsDb(context)

    override suspend fun getMuscleMenu(): List<MuscleTypeItem> {
        Log.d("FixRoad","RoomUserStorage Muscle Create ${muscleTypeDb.getDao().getAllMuscleItems()}")
            return muscleTypeDb.getDao().getAllMuscleItems()
    }

    override suspend fun getExerciseMenu(muscleName:String): List<ExerciseTypeItem> {
        Log.d("FixRoad","RoomUserStorage Exercise Create ${exerciseTypeDb.getDao().getAllExerciseByMuscle(muscleName)}")
        return exerciseTypeDb.getDao().getAllExerciseByMuscle(muscleName)
    }

    override fun saveExerciseStats(exerciseStatItem: ExerciseStatItem) {
        Log.d("FixRoad","RoomUserStorage Exercise Stats Save ${exerciseStatsDb.getDao().insertExerciseStat(exerciseStatItem)}")
        return exerciseStatsDb.getDao().insertExerciseStat(exerciseStatItem)
    }

    override fun getExerciseStats(exerciseName:String): List<ExerciseStatItem> {
        Log.d("FixRoad","RoomUserStorage Exercise Stats Get ${exerciseStatsDb.getDao().getExerciseStatsByExerciseName(exerciseName)}")
        return exerciseStatsDb.getDao().getExerciseStatsByExerciseName(exerciseName)
    }
}