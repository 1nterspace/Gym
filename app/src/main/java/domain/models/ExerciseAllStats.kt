package domain.models

data class ExerciseAllStats(
    val exerciseName:String,
    val exerciseMax:Double,
    val exerciseMin:Double,
    val listOfTrainingSession:List<ExerciseStatItem>
)
