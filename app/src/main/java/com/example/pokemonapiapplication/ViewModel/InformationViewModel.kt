package com.example.pokemonapiapplication.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.pokemonapiapplication.Items.Pokemon
import com.example.pokemonapiapplication.Items.PokemonInfomation.Description
import com.example.pokemonapiapplication.Items.PokemonInfomation.PokemonFlavourText
import com.example.pokemonapiapplication.Retrofit2.ApiInstance
import com.example.pokemonapiapplication.Retrofit2.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InformationViewModel(application: Application) : AndroidViewModel(application) {
    private var pokemonService = ApiInstance.getRetrofit().create(PokemonService::class.java)
    var pokemon = MutableLiveData<Pokemon>()
    var pokemonDescription = MutableLiveData<Description>()

    fun getPokemon(id: String) {
        pokemonService.getPoke(id).enqueue(object : Callback<Pokemon> {
            override fun onFailure(call: Call<Pokemon>, t: Throwable) {

            }

            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                if (response.body() != null) {
                    pokemon.postValue(response.body())
                }
            }

        })
    }

    fun getPokemonDescription(id: String) {
        pokemonService.getPokeDescription(id).enqueue(object : Callback<Description>{
            override fun onFailure(call: Call<Description>, t: Throwable) {

            }

            override fun onResponse(call: Call<Description>, response: Response<Description>) {
                if(response.body() != null){
                    pokemonDescription.postValue(response.body())
                }
            }

        })
    }
}