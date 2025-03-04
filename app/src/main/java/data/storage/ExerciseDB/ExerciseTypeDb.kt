package data.storage.ExerciseDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import domain.models.ExerciseTypeItem

@Database(entities = [ExerciseTypeItem::class], version = 1)
abstract class ExerciseTypeDb:RoomDatabase() {
abstract fun getDao(): ExerciseDao
    companion object{

        fun getExerciseTypeDb(context: Context): ExerciseTypeDb {
            return Room.databaseBuilder(
                context.applicationContext,
                ExerciseTypeDb::class.java,
                "ExerciseTypeDB"
            ).build()
        }

    }
}