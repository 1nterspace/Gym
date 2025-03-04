package domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("MuscleTypes")
data class MuscleTypeItem(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    @ColumnInfo(name = "muscleName")
    var muscleName:String,
    @ColumnInfo(name = "muscleImage")
    val muscleImage:Int
)
