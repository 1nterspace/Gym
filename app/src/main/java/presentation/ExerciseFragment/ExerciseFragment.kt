package presentation.ExerciseFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymlogictest.databinding.FragmentExerciseBinding
import domain.models.ExerciseTypeItem
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import presentation.DataModel


class ExerciseFragment : Fragment(), ExerciseTypeRWAdapter.Listener {

    private lateinit var binding: FragmentExerciseBinding
    private lateinit var adapter: ExerciseTypeRWAdapter
    private val dataModel: DataModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExerciseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ExerciseTypeRWAdapter(this)
        binding.ExerciseHolder.adapter = adapter
        binding.ExerciseHolder.layoutManager = LinearLayoutManager(requireContext())

        dataModel.exerciseTypeItemsList.observe(requireActivity(), Observer {
            adapter.submitList(it)
            binding.MucleName.text = it[0].muscleType
        })

        binding.button.setOnClickListener {
            dataModel.activeFragmentValue.value = 1
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = ExerciseFragment()
    }

    override fun obClick(exerciseTypeItem: ExerciseTypeItem) {
        Toast.makeText(requireContext(),"Exercise", Toast.LENGTH_LONG).show()
        dataModel.activeFragmentValue.value = 3
        dataModel.exerciseName.value = exerciseTypeItem.exerciseName
    }
}