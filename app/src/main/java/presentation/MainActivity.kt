package presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.gymlogictest.R
import com.example.gymlogictest.databinding.MainActivityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import presentation.ExerciseFragment.ExerciseFragment
import presentation.MuscleFragment.MuscleMenuFragment
import presentation.StatsFragment.StatsFragment
import presentation.WorkFragment.ExersiceWorkFragment

class MainActivity:AppCompatActivity() {

    private lateinit var binding:MainActivityBinding
    private val dataModel: DataModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = MainActivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dataModel.activeFragmentValue.value = 1

        dataModel.activeFragmentValue.observe(this, Observer {
            when(it){
                1 -> setUpFragment(MuscleMenuFragment.newInstance(),R.id.fragmentContainer)
                2 -> setUpFragment(ExerciseFragment.newInstance(),R.id.fragmentContainer)
                3 -> setUpFragment(ExersiceWorkFragment.newInstance(),R.id.fragmentContainer)
                4 -> setUpFragment(StatsFragment.newInstance(),R.id.fragmentContainer)
            }
        })


        // Запуск корутины для загрузки данных из базы с названиями группы мышц
        CoroutineScope(Dispatchers.IO).launch {
            try {
                dataModel.getMuscleTypeMenu()
            } catch (e: Exception) {
                Log.e("FixRoad", "Error loading muscle data", e)
            }
        }

    }

    private fun setUpFragment(fragment:Fragment, placeholder:Int){
        supportFragmentManager.beginTransaction().replace(placeholder,fragment).commit()
    }

}