package di

import domain.usecases.GetExerciseMenuUseCase
import domain.usecases.GetExerciseStatsUseCase
import domain.usecases.GetMuscleMenuUseCase
import domain.usecases.SaveExerciseStatsUseCase
import org.koin.dsl.module


val domainDi = module {

    factory<GetMuscleMenuUseCase> {
        GetMuscleMenuUseCase(userRepository = get())
    }

    factory<GetExerciseMenuUseCase> {
        GetExerciseMenuUseCase(userRepository = get())
    }

    factory<SaveExerciseStatsUseCase> {
        SaveExerciseStatsUseCase(userRepository = get())
    }

    factory<GetExerciseStatsUseCase> {
        GetExerciseStatsUseCase(userRepository = get())
    }

}