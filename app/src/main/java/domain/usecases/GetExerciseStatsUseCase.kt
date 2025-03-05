package domain.usecases

import domain.models.ExerciseStatItem
import domain.repository.UserRepository

class GetExerciseStatsUseCase(private val userRepository: UserRepository) {

    fun execute(exerciseName: String): List<ExerciseStatItem> {
        return userRepository.getExerciseStats(exerciseName)
    }

}