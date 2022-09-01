package com.app.android.jetpackcompose.api

import com.app.android.jetpackcompose.model.PokedexModel
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("pokedex")
    suspend fun pokedex(): PokedexModel
}