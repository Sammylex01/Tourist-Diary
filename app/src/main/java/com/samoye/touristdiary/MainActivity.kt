package com.samoye.touristdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.samoye.touristdiary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    var adapter:CityAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpTourDiary()
    }

    private fun setUpTourDiary(){
        adapter = CityAdapter(this, CityData.tourSites)
        binding?.cityListView?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}