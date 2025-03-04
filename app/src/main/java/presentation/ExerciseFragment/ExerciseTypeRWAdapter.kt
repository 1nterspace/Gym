package presentation.ExerciseFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gymlogictest.R
import com.example.gymlogictest.databinding.MuscleTypeCardBinding
import com.squareup.picasso.Picasso
import domain.models.ExerciseTypeItem

class ExerciseTypeRWAdapter(private val listener: Listener) :
    ListAdapter<ExerciseTypeItem, ExerciseTypeRWAdapter.ExerciseTypeHolder>(
        Comparator()
    ) {

    class Comparator : DiffUtil.ItemCallback<ExerciseTypeItem>() {
        override fun areItemsTheSame(oldItem: ExerciseTypeItem, newItem: ExerciseTypeItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ExerciseTypeItem, newItem: ExerciseTypeItem): Boolean {
            return oldItem == newItem
        }

    }

    class ExerciseTypeHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = MuscleTypeCardBinding.bind(itemView)
        fun bind(exerciseTypeItem: ExerciseTypeItem,listener:Listener){
            //Picasso.get().load(exerciseTypeItem.exerciseImage).into(binding.imageView)
            binding.MuscleName.text = exerciseTypeItem.exerciseName
            itemView.setOnClickListener {
                listener.obClick(exerciseTypeItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseTypeHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.muscle_type_card,parent,false
        )
        return ExerciseTypeHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseTypeHolder, position: Int) {
        val exerciseItem = getItem(position)
        return holder.bind(exerciseItem,listener)
    }

    interface Listener {
        fun obClick(exerciseTypeItem: ExerciseTypeItem)
    }
}