package com.sonder.androidmaster.superHero

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sonder.androidmaster.databinding.ItemSuperHeroApiBinding
import com.sonder.androidmaster.superHero.data.SuperHeroItemResponse
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperHeroApiBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvApiSuperheroName.text = superHeroItemResponse.name
        Picasso.get().load(superHeroItemResponse.image.url).into(binding.ivSuperHeroPhoto)
        binding.root.setOnClickListener{ onItemSelected(superHeroItemResponse.id) }
    }
}