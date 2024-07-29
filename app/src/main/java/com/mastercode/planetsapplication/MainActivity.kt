package com.mastercode.planetsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the adapterView
        val listView = findViewById<ListView>(R.id.listView)

        // The data source
        val mercury = Planet("Mercury","0 Moons",R.drawable.mercury)
        val venus = Planet("Venus","0 Moons",R.drawable.venus)
        val earth = Planet("Earth","1 Moon",R.drawable.earth)
        val mars = Planet("Mars","2 Moons",R.drawable.mars)
        val jupiter = Planet("Jupiter","79 Moons",R.drawable.jupiter)
        val saturn = Planet("Saturn","83 Moons",R.drawable.saturn)
        val uranus = Planet("Uranus","27 Moons",R.drawable.uranus)
        val neptune = Planet("Neptune","14 Moons",R.drawable.neptune)

        // Add the planets to the planets array list
        val planetList = ArrayList<Planet>()
        planetList.add(mercury)
        planetList.add(venus)
        planetList.add(earth)
        planetList.add(mars)
        planetList.add(jupiter)
        planetList.add(saturn)
        planetList.add(uranus)
        planetList.add(neptune)

        // Create the adapter
        val myAdapter = MoonCustomAdapter(this, planetList)
        listView.adapter = myAdapter
    }

}