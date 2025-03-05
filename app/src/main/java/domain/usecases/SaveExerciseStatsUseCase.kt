package domain.usecases

import domain.models.ExerciseStatItem
import domain.repository.UserRepository

class SaveExerciseStatsUseCase(private val userRepository: UserRepository) {

    fun execute(exerciseStatItem: ExerciseStatItem) {
        return userRepository.saveExerciseStats(exerciseStatItem)
    }

}