package com.sonder.androidmaster.appsuperhero.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.sonder.androidmaster.R
import com.sonder.androidmaster.appsuperhero.SuperHero

class SuperHeroViewHolder(view:View): RecyclerView.ViewHolder(view) {

    val superHero = view.findViewById<TextView>(R.id.superHeroName)
    val realName = view.findViewById<TextView>(R.id.superHeroRealName)
    val publisher = view.findViewById<TextView>(R.id.superHeroPublisher)
    val photo = view.findViewById<ImageView>(R.id.superHeroImage)

    fun render(superHeroModel: SuperHero){
        superHero.text = superHeroModel.superHero
        realName.text = superHeroModel.realName
        publisher.text = superHeroModel.publisher
        Glide.with(photo.context).load(superHeroModel.photo).into(photo)
    }
}