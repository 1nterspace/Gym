package domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("ExerciseTypes")
data class ExerciseTypeItem(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    @ColumnInfo(name = "muscleName")
    val muscleType:String,
    @ColumnInfo(name = "exerciseName")
    val exerciseName:String,
    @ColumnInfo(name = "ExerciseImage")
    val exerciseImage:Int
)
