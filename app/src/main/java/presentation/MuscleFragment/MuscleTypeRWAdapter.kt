package presentation.MuscleFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gymlogictest.R
import com.example.gymlogictest.databinding.MuscleTypeCardBinding
import com.squareup.picasso.Picasso
import domain.models.MuscleTypeItem

class MuscleTypeRWAdapter(private val listener: Listener) :
    ListAdapter<MuscleTypeItem, MuscleTypeRWAdapter.Holder>(
        Comparator()
    ) {

    class Comparator : DiffUtil.ItemCallback<MuscleTypeItem>() {
        override fun areItemsTheSame(oldItem: MuscleTypeItem, newItem: MuscleTypeItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MuscleTypeItem, newItem: MuscleTypeItem): Boolean {
            return oldItem == newItem
        }

    }

    class Holder(view: View) : ViewHolder(view) {
        private val binding = MuscleTypeCardBinding.bind(itemView)

        fun bind(muscleTypeItem: MuscleTypeItem, listener: Listener) {
            //Picasso.get().load(muscleTypeItem.muscleImage).into(binding.imageView)
            binding.MuscleName.text = muscleTypeItem.muscleName
            itemView.setOnClickListener {
                listener.obClick(muscleTypeItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.muscle_type_card, parent, false
        )
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val muscleItem = getItem(position)
        return holder.bind(muscleItem, listener)
    }


    interface Listener {
        fun obClick(muscleTypeItem: MuscleTypeItem)
    }

}