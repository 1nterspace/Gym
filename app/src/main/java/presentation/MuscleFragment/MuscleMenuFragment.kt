package presentation.MuscleFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymlogictest.databinding.FragmentMuscleMenuBinding
import domain.models.MuscleTypeItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import presentation.DataModel

class MuscleMenuFragment : Fragment(), MuscleTypeRWAdapter.Listener {

    private lateinit var binding: FragmentMuscleMenuBinding
    private lateinit var adapter: MuscleTypeRWAdapter
    private val dataModel: DataModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMuscleMenuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                dataModel.getMuscleTypeMenu()
            } catch (e: Exception) {
                Log.e("FixRoad", "Error loading muscle data", e)
            }
        }

        adapter = MuscleTypeRWAdapter(this)
        binding.placeHolder.adapter = adapter
        binding.placeHolder.layoutManager = LinearLayoutManager(requireContext())

        // Подписка на LiveData
        dataModel.muscleTypeItemsList.observe(requireActivity(), Observer { muscleTypeItems ->
            adapter.submitList(muscleTypeItems)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MuscleMenuFragment()
    }

    override fun obClick(muscleTypeItem: MuscleTypeItem) {
        CoroutineScope(Dispatchers.IO).launch {
            dataModel.getExerciseTypeMenu(muscleTypeItem.muscleName)
        }
        dataModel.activeFragmentValue.value = 2
    }

}
