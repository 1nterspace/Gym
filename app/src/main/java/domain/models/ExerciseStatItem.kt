package domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ExerciseStats")
data class ExerciseStatItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "exerciseName")
    val exerciseName: String,
    @ColumnInfo(name = "data")
    val data: String,

    @ColumnInfo(name = "firstRepKg")
    val firstRepKg: String,
    @ColumnInfo(name = "firstRepCount")
    val firstRepCount: String,

    @ColumnInfo(name = "secondRepKg")
    val secondRepKg: String,
    @ColumnInfo(name = "secondRepCount")
    val secondRepCount: String,

    @ColumnInfo(name = "thirdRepKg")
    val thirdRepKg: String,
    @ColumnInfo(name = "thirdRepCount")
    val thirdRepCount: String,

    @ColumnInfo(name = "forthRepKg")
    val forthRepKg: String,
    @ColumnInfo(name = "forthRepCount")
    val forthRepCount: String,


    )
