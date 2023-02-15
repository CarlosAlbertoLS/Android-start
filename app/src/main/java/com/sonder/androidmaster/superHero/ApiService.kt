package com.sonder.androidmaster.superHero

import com.sonder.androidmaster.superHero.data.SuperHeroResponse
import com.sonder.androidmaster.superHero.data.SuperheroDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("6185983864799539/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superHeroName:String):Response<SuperHeroResponse>

    @GET("6185983864799539/{id}")
    suspend fun getSuperheroDetail(@Path("id") superHeroId: String): Response<SuperheroDetailResponse>
}