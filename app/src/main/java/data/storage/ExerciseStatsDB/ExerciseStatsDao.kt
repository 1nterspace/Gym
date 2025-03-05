package data.storage.ExerciseStatsDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import domain.models.ExerciseStatItem

@Dao
interface ExerciseStatsDao {

    @Insert
    fun insertExerciseStat(exerciseStatItem: ExerciseStatItem)

    @Query("SELECT * FROM exercisestats WHERE exerciseName = :exerciseName")
    fun getExerciseStatsByExerciseName(exerciseName: String): List<ExerciseStatItem>

    @Query("DELETE FROM ExerciseStats") // Удаление всех записей из таблицы
    suspend fun deleteAll()

}