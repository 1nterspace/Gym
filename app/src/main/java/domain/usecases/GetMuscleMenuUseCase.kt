package domain.usecases

import android.util.Log
import domain.models.MuscleTypeItem
import domain.repository.UserRepository

class GetMuscleMenuUseCase(private val userRepository: UserRepository) {

    suspend fun execute(): List<MuscleTypeItem> {
        Log.d("FixRoad", "GetMuscleMenuUseCase Created")
        return userRepository.getMuscleMenu()
    }

}