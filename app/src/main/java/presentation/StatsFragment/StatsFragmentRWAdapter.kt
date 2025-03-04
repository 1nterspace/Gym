package presentation.StatsFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gymlogictest.R
import com.example.gymlogictest.databinding.StatsHistoryCardBinding
import domain.models.ExerciseStatItem

class StatsFragmentRWAdapter:ListAdapter<ExerciseStatItem, StatsFragmentRWAdapter.StatsViewHolder>(Comparator()) {

    class Comparator : DiffUtil.ItemCallback<ExerciseStatItem>() {
        override fun areItemsTheSame(oldItem: ExerciseStatItem, newItem: ExerciseStatItem): Boolean {
            return oldItem.data == newItem.data
        }

        override fun areContentsTheSame(oldItem: ExerciseStatItem, newItem: ExerciseStatItem): Boolean {
            return oldItem == newItem
        }

    }

    class StatsViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = StatsHistoryCardBinding.bind(itemView)
        fun bind(exerciseStatItem: ExerciseStatItem){
            binding.textData.text = exerciseStatItem.data

            binding.textFirstRepKg.text = exerciseStatItem.firstRepKg.toString()
            binding.textFirstRepCount.text = exerciseStatItem.firstRepCount.toString()

            binding.textSecondRepKg.text = exerciseStatItem.secondRepKg.toString()
            binding.textSecondRepCount.text = exerciseStatItem.secondRepCount.toString()

            binding.textThirdRepKg.text = exerciseStatItem.thirdRepKg.toString()
            binding.textThirdRepCount.text = exerciseStatItem.thirdRepCount.toString()

            binding.textFourthRepKg.text = exerciseStatItem.forthRepKg.toString()
            binding.textFourthRepCount.text = exerciseStatItem.forthRepCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.stats_history_card,parent,false
        )
        return StatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        val statsHistoryItem = getItem(position)
        return holder.bind(statsHistoryItem)
    }

}