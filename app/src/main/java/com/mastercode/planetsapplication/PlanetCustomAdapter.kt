package com.mastercode.planetsapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MoonCustomAdapter(private val context:Context, private val planetsList:List<Planet>):BaseAdapter(){
    override fun getCount(): Int {
        // Returns the number of items in the data set
        return planetsList.size
    }

    override fun getItem(position: Int): Any {
        // Returns the data item associated with the specified position
        return planetsList[position]
    }

    override fun getItemId(position: Int): Long {
        // Returns a unique identifier for the item at the specified position
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Returns a view that displays the data at the specified position
         val inflater = context.getSystemService(
             Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view:View

        // Create a new view if the convertView is null
        if (convertView == null){
            view = inflater.inflate(R.layout.custom_planet_layout, parent, false)
        }else{
            // If the convertView isn't null the reuse the existing view
            view = convertView
        }

        // Bind the views
        val item = getItem(position) as Planet

        // Initialize the views
        val planetName = view.findViewById<TextView>(R.id.planetName)
        val moonCount = view.findViewById<TextView>(R.id.moonCount)
        val planetImg = view.findViewById<ImageView>(R.id.planetImage)

        planetName.text = item.planetName
        moonCount.text = item.moonCount
        planetImg.setImageResource(item.moonImg)
        
        // Setting a click listener on the planets' views
        view.setOnClickListener {
            Toast.makeText(context, planetsList[position].planetName, Toast.LENGTH_SHORT).show()
        }

        return view
    }
}