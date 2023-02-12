package com.sonder.androidmaster.superHero.data

import com.google.gson.annotations.SerializedName

data class SuperHeroResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superHeroes: List<SuperHeroItemResponse>
)

data class SuperHeroItemResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: Image
)

data class Image(
    val url: String
)