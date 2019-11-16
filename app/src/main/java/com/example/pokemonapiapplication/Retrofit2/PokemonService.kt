package com.example.pokemonapiapplication.Retrofit2

import retrofit2.Call
import com.example.pokemonapiapplication.Items.Pokemon
import com.example.pokemonapiapplication.Items.PokemonInfomation.Description
import com.example.pokemonapiapplication.Items.PokemonInfomation.PokemonFlavourText
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/")
    fun getAllPokemon(): Call<ArrayList<Pokemon>>

    @GET("pokemon/{key}/")
    fun getPoke(@Path("key")key : String) : Call<Pokemon>

    @GET("pokemon-species/{id}/")
    fun getPokeDescription(@Path("id") id : String) : Call<Description>

}