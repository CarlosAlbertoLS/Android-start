package com.sonder.androidmaster.appsuperhero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.sonder.androidmaster.R
import com.sonder.androidmaster.appsuperhero.SuperHero

class SuperHeroAdapter(private val superHeroList: List<SuperHero>): RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.render(item)
    }

    override fun getItemCount() =  superHeroList.size
}