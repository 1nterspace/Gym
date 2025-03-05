package presentation.WorkFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.gymlogictest.databinding.FragmentExersiceWorkBinding
import data.storage.ExerciseStatsDB.ExerciseStatsDb
import domain.models.ExerciseStatItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import presentation.DataModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ExersiceWorkFragment : Fragment() {

    private lateinit var binding: FragmentExersiceWorkBinding
    private val dataModel: DataModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExersiceWorkBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val exerciseStatsDb = ExerciseStatsDb.getExerciseStatsDb(requireContext())

        val exerciseName = dataModel.exerciseName.value ?: "Unknown Exercise"
        binding.textNameOfExercise.text = exerciseName

        binding.buttonGetStats.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                dataModel.getExerciseStats(exerciseName)
            }
            dataModel.activeFragmentValue.value = 4
        }
        binding.buttonBack.setOnClickListener {
            dataModel.activeFragmentValue.value = 2
        }

        // Получить текущую дату
        val currentDate = LocalDate.now()
        // Форматирование даты
        val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        binding.editTextData.setText(formattedDate.toString())

        binding.buttonSave.setOnClickListener {
            // Получаем данные из EditText
            val firstRepKg = binding.editTextFirstRepKg.text.toString().toIntOrNull() ?: 0
            val firstRepCount = binding.editTextFirstRepCount.text.toString().toIntOrNull() ?: 0

            val secondRepKg = binding.editTextSecondRepKg.text.toString().toIntOrNull() ?: 0
            val secondRepCount = binding.editTextSecondRepCount.text.toString().toIntOrNull() ?: 0

            val thirdRepKg = binding.editTextThirdRepKg.text.toString().toIntOrNull() ?: 0
            val thirdRepCount = binding.editTextThirdRepCount.text.toString().toIntOrNull() ?: 0

            val fourthRepKg = binding.editTextFourthRepKg.text.toString().toIntOrNull() ?: 0
            val fourthRepCount = binding.editTextFourthRepCount.text.toString().toIntOrNull() ?: 0

            // Проверяем, что все поля заполнены
            if (firstRepKg == 0 || firstRepCount == 0 ||
                secondRepKg == 0 || secondRepCount == 0 ||
                thirdRepKg == 0 || thirdRepCount == 0 ||
                fourthRepKg == 0 || fourthRepCount == 0
            ) {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val exerciseStatItem = ExerciseStatItem(
                exerciseName = dataModel.exerciseName.value ?: "Unknown Exercise",
                data = formattedDate.toString(),
                firstRepKg = firstRepKg.toString(),
                firstRepCount = firstRepCount.toString(),
                secondRepKg = secondRepKg.toString(),
                secondRepCount = secondRepCount.toString(),
                thirdRepKg = thirdRepKg.toString(),
                thirdRepCount = thirdRepCount.toString(),
                forthRepKg = fourthRepKg.toString(),
                forthRepCount = fourthRepCount.toString()
            )
            CoroutineScope(Dispatchers.IO).launch {
                exerciseStatsDb.getDao().insertExerciseStat(exerciseStatItem)
                //dataModel.saveExerciseStats(exerciseStatItem)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExersiceWorkFragment()
    }
}