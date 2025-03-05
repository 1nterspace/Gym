package data.storage.MuscleDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import domain.models.MuscleTypeItem

@Database(entities = [MuscleTypeItem::class], version = 1)
abstract class MuscleTypeDb : RoomDatabase() {
    abstract fun getDao(): MuscleDao

    companion object {
        fun getMuscleTypeDb(context: Context): MuscleTypeDb {
            return Room.databaseBuilder(
                context.applicationContext,
                MuscleTypeDb::class.java,
                "MuscleTypeDB"
            ).build()
        }

    }
}