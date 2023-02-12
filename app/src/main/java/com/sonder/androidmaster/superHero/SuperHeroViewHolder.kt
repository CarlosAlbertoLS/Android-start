package com.sonder.androidmaster.superHero

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sonder.androidmaster.databinding.ItemSuperHeroApiBinding

import com.sonder.androidmaster.superHero.data.SuperHeroItemResponse

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperHeroApiBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse){
        binding.tvApiSuperheroName.text = superHeroItemResponse.name
        binding.ivSuperHeroPhoto.load(superHeroItemResponse.image.url)
    }
}