package com.samoye.touristdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.samoye.touristdiary.databinding.ActivityMainBinding
import com.samoye.touristdiary.databinding.ActivityTourBinding

class TourActivity : AppCompatActivity() {
    private var binding:ActivityTourBinding? = null
    private  var cityImage = 0
    private var cityName:String? = null
    private  var cityAbout:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTourBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        cityImage = intent.getIntExtra(CityAdapter.CITY_IMAGE_EXTRAS, 0)
        cityName = intent.getStringExtra(CityAdapter.CITY_NAME_EXTRAS)
        cityAbout = intent.getStringExtra(CityAdapter.ABOUT_EXTRAS)
        setUpTouristSites()
    }

    private fun setUpTouristSites(){
        binding?.aboutTv?.text = cityAbout
        binding?.cityIv?.setImageResource(cityImage)
        title = cityName
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}