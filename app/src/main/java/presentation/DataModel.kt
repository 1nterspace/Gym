package presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.models.ExerciseStatItem
import domain.models.ExerciseTypeItem
import domain.models.MuscleTypeItem
import domain.usecases.GetExerciseMenuUseCase
import domain.usecases.GetExerciseStatsUseCase
import domain.usecases.GetMuscleMenuUseCase
import domain.usecases.SaveExerciseStatsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataModel(
    private val getMuscleMenuUseCase: GetMuscleMenuUseCase,
    private val getExerciseMenuUseCase: GetExerciseMenuUseCase,
    private val saveExerciseStatsUseCase: SaveExerciseStatsUseCase,
    private val getExerciseStatsUseCase: GetExerciseStatsUseCase
) : ViewModel() {

    val activeFragmentValue = MutableLiveData<Int>()

    val exerciseName = MutableLiveData<String>()

    val muscleTypeItemsList = MutableLiveData<List<MuscleTypeItem>>()

    suspend fun getMuscleTypeMenu() {
        val muscleTypeList = getMuscleMenuUseCase.execute()
        Log.d("FixRoad", "Data muscle loaded: ${muscleTypeList.size} items")
        withContext(Dispatchers.Main) {
            muscleTypeItemsList.value = muscleTypeList
            Log.d("FixRoad", "MuscleTypeItemsList: ${muscleTypeItemsList.value} items")
        }
    }

    val exerciseTypeItemsList = MutableLiveData<List<ExerciseTypeItem>>()

    suspend fun getExerciseTypeMenu(muscleName: String) {
        Log.d(
            "FixRoad",
            "Data exercise loaded: ${getExerciseMenuUseCase.execute(muscleName).size} items"
        )
        val exerciseList = withContext(Dispatchers.IO) {
            getExerciseMenuUseCase.execute(muscleName)
        }
        withContext(Dispatchers.Main) {
            exerciseTypeItemsList.value = exerciseList
            Log.d("FixRoad", "ExerciseTypeItemsList: ${exerciseTypeItemsList.value} items")
        }
    }

    val exerciseItemsStatsList = MutableLiveData<List<ExerciseStatItem>>()

    suspend fun getExerciseStats(exerciseName: String) {
        val exerciseStatsList = withContext(Dispatchers.IO) {
            getExerciseStatsUseCase.execute(exerciseName)
        }
        withContext(Dispatchers.Main) {
            exerciseItemsStatsList.value = exerciseStatsList
            Log.d("FixRoad", "exerciseItemsStatsList: ${exerciseTypeItemsList.value} items")
        }
    }

    suspend fun saveExerciseStats(exerciseStatItem: ExerciseStatItem) {
        withContext(Dispatchers.IO) {
            saveExerciseStatsUseCase.execute(exerciseStatItem)
        }
    }

}