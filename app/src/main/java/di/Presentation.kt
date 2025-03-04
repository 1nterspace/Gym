package di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import presentation.DataModel

val presentationDi = module {

    viewModel<DataModel> {
        DataModel(
            getMuscleMenuUseCase = get(),
            getExerciseMenuUseCase = get(),
            saveExerciseStatsUseCase = get(),
            getExerciseStatsUseCase = get()
        )
    }

}