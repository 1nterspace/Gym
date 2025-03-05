package presentation.StatsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymlogictest.databinding.FragmentStatsBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import presentation.DataModel


class StatsFragment : Fragment() {

    lateinit var binding: FragmentStatsBinding
    private lateinit var adapter: StatsFragmentRWAdapter
    private val dataModel: DataModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = StatsFragmentRWAdapter()
        binding.statsHistoryHolder.adapter = adapter
        binding.statsHistoryHolder.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
        binding.textExerciseName.text = dataModel.exerciseName.value
        binding.buttonBack.setOnClickListener {
            dataModel.activeFragmentValue.value = 3
        }
        dataModel.exerciseItemsStatsList.observe(requireActivity(), Observer {
            adapter.submitList(it)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatsFragment()
    }
}