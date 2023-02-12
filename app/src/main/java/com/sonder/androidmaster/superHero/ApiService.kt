package com.sonder.androidmaster.superHero

import com.sonder.androidmaster.superHero.data.SuperHeroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("6185983864799539/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superHeroName:String):Response<SuperHeroResponse>
}