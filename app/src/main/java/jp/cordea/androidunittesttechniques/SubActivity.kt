package jp.cordea.androidunittesttechniques

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.cordea.androidunittesttechniques.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private val mutableItems = mutableListOf<Int>()
    val items: List<Int> = mutableItems

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
                .setContentView<ActivitySubBinding>(this, R.layout.activity_sub)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            mutableItems.add(0)
        }
    }
}
