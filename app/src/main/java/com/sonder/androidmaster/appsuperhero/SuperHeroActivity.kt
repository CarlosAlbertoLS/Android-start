package com.sonder.androidmaster.appsuperhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sonder.androidmaster.R
import com.sonder.androidmaster.appsuperhero.adapter.SuperHeroAdapter
import com.sonder.androidmaster.databinding.ActivitySuperHeroBinding

class SuperHeroActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rvSuperHero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList)
    }
}