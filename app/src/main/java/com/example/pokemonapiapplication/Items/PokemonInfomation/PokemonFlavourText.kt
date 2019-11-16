package com.example.pokemonapiapplication.Items.PokemonInfomation

import com.google.gson.annotations.SerializedName

class PokemonFlavourText {
    @SerializedName("flavor_text")
    var description: String

    constructor(description : String){
        this.description = description
    }
}