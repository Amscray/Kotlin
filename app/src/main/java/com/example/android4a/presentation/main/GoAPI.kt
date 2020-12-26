package com.example.android4a.presentation.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.data.API.PokeApi
import com.example.android4a.R
import com.example.android4a.data.adapter.ListAdapter
import com.example.android4a.domain.model.Pokemon
import com.example.android4a.domain.model.RestPokemonResponse
import kotlinx.android.synthetic.main.activity_main3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GoAPI : AppCompatActivity() {


    var mAdapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        activity_main3.layoutManager = LinearLayoutManager(this)

        makeApiCall()
    }






    fun ShowPokemon(listPokemon: MutableList<Pokemon>?) {
        mAdapter = ListAdapter(listPokemon ,this)
        activity_main3?.adapter = mAdapter;

    }

    fun makeApiCall() {
        val BASE_URL: String = "https://pokeapi.co/"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PokeApi::class.java)
        val Pokemon = service.getPokemonResponse()
        Pokemon.enqueue(object : Callback<RestPokemonResponse> {
            override fun onFailure(call: Call<RestPokemonResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<RestPokemonResponse>, response: Response<RestPokemonResponse>
            ) {

                    var pokemonList: MutableList<Pokemon>? = response.body()?.getResults()
                    ShowPokemon(pokemonList)




            }

        })


    }

}

