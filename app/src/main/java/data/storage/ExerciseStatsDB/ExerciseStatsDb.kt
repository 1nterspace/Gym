package data.storage.ExerciseStatsDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import domain.models.ExerciseStatItem

@Database(entities = [ExerciseStatItem::class], version = 1)
abstract class ExerciseStatsDb : RoomDatabase() {

    abstract fun getDao(): ExerciseStatsDao

    companion object {
        fun getExerciseStatsDb(context: Context): ExerciseStatsDb {
            return Room.databaseBuilder(
                context.applicationContext,
                ExerciseStatsDb::class.java,
                "ExerciseStatsDB"
            ).build()
        }

    }

}