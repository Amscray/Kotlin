package com.example.android4a.data.API

import com.example.android4a.domain.model.RestPokemonResponse
import retrofit2.Call
import retrofit2.http.GET


interface PokeApi {

    @GET("/api/v2/pokemon?limit=807")
    fun getPokemonResponse (): Call<RestPokemonResponse>


}