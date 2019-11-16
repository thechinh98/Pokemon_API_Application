package com.example.pokemonapiapplication.Items.PokemonInfomation

import com.google.gson.annotations.SerializedName

class Description {
    @SerializedName("flavor_text_entries")
    var flavorTextList : ArrayList<PokemonFlavourText>

    constructor(flavorTextList : ArrayList<PokemonFlavourText>){
        this.flavorTextList = flavorTextList
    }
}