package domain.usecases

import domain.models.ExerciseTypeItem
import domain.repository.UserRepository

class GetExerciseMenuUseCase(private val userRepository: UserRepository) {

    suspend fun execute(muscleName:String):List<ExerciseTypeItem>{
        return userRepository.getExerciseMenu(muscleName)
    }

}