package com.cbellmont.searchbar

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.cbellmont.searchbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val list = listOf("Alumno 1","Alumno 2","Alumno 3","Profesor 1","Profesor 2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.swSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                Log.d(MainActivity::class.java.name, "onQueryTextSubmit ha recibido $p0")
                p0?.let {
                    binding.tvResult.text = list.filter { it.contains(p0) }.toString()
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                Log.d(MainActivity::class.java.name, "onQueryTextChange ha recibido $p0")
                p0?.let {
                    binding.tvResult.text = list.filter { it.contains(p0) }.toString()
                }
                return true
            }
        })

        binding.tvResult.text = list.toString()
    }
}