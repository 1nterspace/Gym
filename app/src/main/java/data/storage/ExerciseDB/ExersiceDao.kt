package data.storage.ExerciseDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import domain.models.ExerciseTypeItem

@Dao
interface ExerciseDao {

    @Insert
    fun insertExerciseItem(item: ExerciseTypeItem)

    @Query("SELECT * FROM exercisetypes WHERE muscleName = :muscleName")
    fun getAllExerciseByMuscle(muscleName:String):List<ExerciseTypeItem>

}