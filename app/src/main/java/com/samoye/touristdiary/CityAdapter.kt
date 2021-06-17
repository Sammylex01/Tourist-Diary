package com.samoye.touristdiary

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CityAdapter(context: Context, tourSites:List<CityModel>):ArrayAdapter<CityModel>(context, 0, tourSites) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val tourSites = getItem(position)
        if(view == null){
            view = LayoutInflater.from(parent.context).inflate(R.layout.tour_item, parent, false)
        }

        val image = view?.findViewById<ImageView>(R.id.cityImage)
        val name = view?.findViewById<TextView>(R.id.cityName)

        tourSites?.cityPicture?.let{
            image?.setImageResource(tourSites.cityPicture)
        }
        name?.text = tourSites?.cityName

        view?.setOnClickListener{
            val intent = Intent(parent.context, TourActivity::class.java)
            intent.putExtra(CITY_IMAGE_EXTRAS,tourSites?.cityPicture)
            intent.putExtra(CITY_NAME_EXTRAS,tourSites?.cityName)
            intent.putExtra(ABOUT_EXTRAS,tourSites?.about)
            parent.context.startActivity(intent)
        }
        return view!!
    }

    //Intent Keys
    companion object{
        val CITY_IMAGE_EXTRAS = "city_image_extras"
        val CITY_NAME_EXTRAS = "city_name_extras"
        val ABOUT_EXTRAS = "about_extras"
    }
}