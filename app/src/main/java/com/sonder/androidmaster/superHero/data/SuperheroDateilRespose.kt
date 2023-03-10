package com.sonder.androidmaster.superHero.data

import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("image") val image: ImageResponse,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("appearance") val appearance: heightAndWeight,
    @SerializedName("work") val work: Work
)

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class ImageResponse(
    @SerializedName("url") val url: String
)

data class Biography(
    @SerializedName("full-name") val realName: String,
    @SerializedName("publisher") val publisher: String
)

data class heightAndWeight(
    @SerializedName("height") val altura: List<String>,
    @SerializedName("weight") val peso: List<String>
)

data class Work(
    @SerializedName("occupation") val occupation: String,
    @SerializedName("base") val base: String
)