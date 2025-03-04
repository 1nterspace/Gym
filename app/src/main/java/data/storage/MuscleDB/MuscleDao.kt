package data.storage.MuscleDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import domain.models.MuscleTypeItem

@Dao
interface MuscleDao {

    @Insert
    fun insertMuscleItem(item:MuscleTypeItem)

    @Query("SELECT * FROM muscletypes")
    fun getAllMuscleItems():List<MuscleTypeItem>

}